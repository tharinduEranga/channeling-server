package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.AdminDTO;
import lk.ijse.absd.channeling.dto.DaysDTO;
import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.*;
import lk.ijse.absd.channeling.repository.*;
import lk.ijse.absd.channeling.service.AdminService;
import lk.ijse.absd.channeling.service.DoctorService;
import lk.ijse.absd.channeling.util.Roles;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AdminDocRepository adminDocRepository;

    @Autowired
    private DocDaysRepository docDaysRepository;

    @Autowired
    private DaysRepository daysRepository;

    private static final Logger logger = Logger.getLogger(DoctorServiceImpl.class);

    @Override
    public CommonResponse<DoctorDTO> add(DoctorDTO doctorDTO) {
        try {
            if (doctorDTO.getSpeciality() == null || !specialityRepository.findById(doctorDTO.getSpeciality().getSpecialityId()).isPresent()) {
                return new CommonResponse<>(false, "Please add the speciality of the doctor!");
            }
            if (doctorDTO.getHospital() == null || !hospitalRepository.findById(doctorDTO.getHospital().getHospitalId()).isPresent()) {
                return new CommonResponse<>(false, "Please add the hospital of the doctor!");
            }
            AdminDTO adminDTO = doctorDTO.getAdminDTO();
            if (adminDTO != null) {
                adminDTO.setRoles(Roles.DOCTOR);
                CommonResponse<AdminDTO> commonResponse = adminService.add(adminDTO);
                if (!commonResponse.isSuccess()) {
                    return new CommonResponse<>(false, commonResponse.getMessage());
                }
                adminDTO = commonResponse.getBody();
            }
            Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
            doctor = doctorRepository.save(doctor);
            if (doctorDTO.getDaysDTOs() != null && doctorDTO.getDaysDTOs().size() > 0) {
                for (DaysDTO daysDTO : doctorDTO.getDaysDTOs()) {
                    Optional<Days> dayById = daysRepository.findById(daysDTO.getDayId());
                    if (dayById.isPresent()) {
                        Days days = dayById.get();
                        Doc_days doc_days = new Doc_days(daysDTO.getFrom(), daysDTO.getTo(), doctor, days);
                        doc_days = docDaysRepository.save(doc_days);
                    }
                }
            }
            if (adminDTO != null) {
                adminDocRepository.save(new Admin_doctor(modelMapper.map(adminDTO, Admin.class), doctor));
            }
            doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
            return new CommonResponse<>(true, doctorDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, JpaSystemException.class}, propagation = Propagation.REQUIRED)
    public CommonResponse<DoctorDTO> update(DoctorDTO doctorDTO) {
        try {
            Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
            Optional<Doctor> docById = doctorRepository.findById(doctorDTO.getDoctorId());
            if (!docById.isPresent()) {
                return new CommonResponse<>(false, "No doctor found !");
            }
            logger.info(doctorDTO.getAdminDTO());
            if (doctorDTO.getAdminDTO().getPassword() == null && doctor.getAdmin_doctors() != null &&
                    docById.get().getAdmin_doctors().size() > 0) {
                doctorDTO.getAdminDTO().setPassword(docById.get().getAdmin_doctors().get(0).getAdmin().getPassword());
            }
            doctorDTO.getAdminDTO().setRoles(Roles.DOCTOR);
            CommonResponse<AdminDTO> adminDTOResponse = adminService.update(doctorDTO.getAdminDTO());
            logger.info(adminDTOResponse);
            doctor = doctorRepository.save(doctor);
            List<DaysDTO> daysDTOs = doctorDTO.getDaysDTOs();
            if (daysDTOs != null && daysDTOs.size() > 0) {
                for (DaysDTO daysDTO : daysDTOs) {
                    Days days = modelMapper.map(daysDTO, Days.class);
                    Doc_days doc_days = new Doc_days(daysDTO.getFrom(), daysDTO.getTo(), doctor, days);
                    Optional<Doc_days> doc_day_by_id = docDaysRepository.findById(new Doc_days_pk(doctorDTO.getDoctorId(), daysDTO.getDayId()));
                    if (doc_day_by_id.isPresent()) {
                        doc_days = doc_day_by_id.get();
                        doc_days.setDoctor(doctor);
                        doc_days.setDays(days);
                        doc_days.setTimeFrom(daysDTO.getFrom());
                        doc_days.setTimeTo(daysDTO.getTo());
                    }
                    doc_days = docDaysRepository.save(doc_days);
                }
            }
            return new CommonResponse<>(true, modelMapper.map(doctor, DoctorDTO.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<DoctorDTO> search(Integer integer) {
        try {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(integer);
            if (!optionalDoctor.isPresent()) {
                return new CommonResponse<>(false, "No doctor found !");
            }
            Doctor doctor = optionalDoctor.get();
            DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
            List<Admin_doctor> admin_doctors = doctor.getAdmin_doctors();
            if (admin_doctors.size() > 0) {
                AdminDTO adminDTO = modelMapper.map(admin_doctors.get(0).getAdmin(), AdminDTO.class);
                adminDTO.setPassword(null);
                doctorDTO.setAdminDTO(adminDTO);
            }
            List<Doc_days> docDays = doctor.getDoc_days();
            setDocDays(doctorDTO, docDays);
            return new CommonResponse<>(true, doctorDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<DoctorDTO> delete(Integer integer) {
        try {
            Optional<Doctor> doctor = doctorRepository.findById(integer);
            if (doctor.isPresent()) {
                doctorRepository.delete(doctor.get());
                return new CommonResponse<>(true, "Doctor is deleted !");
            }
            return new CommonResponse<>(false, "No doctor found !");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<DoctorDTO>> getAll() {
        try {
            List<DoctorDTO> doctorDTOS = new ArrayList<>();
            List<Doctor> doctorList = doctorRepository.findAll();
            doctorList.forEach(doctor -> {
                DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
                List<Admin_doctor> admin_doctors = doctor.getAdmin_doctors();
                if (admin_doctors.size() > 0) {
                    AdminDTO adminDTO = modelMapper.map(admin_doctors.get(0).getAdmin(), AdminDTO.class);
                    adminDTO.setPassword(null);
                    doctorDTO.setAdminDTO(adminDTO);
                }
                List<Doc_days> docDays = doctor.getDoc_days();
                setDocDays(doctorDTO, docDays);
                doctorDTOS.add(doctorDTO);
            });
            return new CommonResponse<>(true, doctorDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    private void setDocDays(DoctorDTO doctorDTO, List<Doc_days> docDays) {
        docDays.forEach(doc_days -> {
            Days days = doc_days.getDays();
            DaysDTO daysDTO = new DaysDTO();
            daysDTO.setDay(days.getDay());
            daysDTO.setFrom(doc_days.getTimeFrom());
            daysDTO.setTo(doc_days.getTimeTo());
            daysDTO.setDayId(days.getDayId());
            doctorDTO.getDaysDTOs().add(daysDTO);
        });
    }
}
