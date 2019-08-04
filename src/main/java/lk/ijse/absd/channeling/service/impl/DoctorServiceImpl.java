package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.AdminDTO;
import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Admin;
import lk.ijse.absd.channeling.entity.Admin_doctor;
import lk.ijse.absd.channeling.entity.Doctor;
import lk.ijse.absd.channeling.repository.AdminDocRepository;
import lk.ijse.absd.channeling.repository.DoctorRepository;
import lk.ijse.absd.channeling.repository.HospitalRepository;
import lk.ijse.absd.channeling.repository.SpecialityRepository;
import lk.ijse.absd.channeling.service.AdminService;
import lk.ijse.absd.channeling.service.DoctorService;
import lk.ijse.absd.channeling.util.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
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

    @Override
    @Transactional
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
    public CommonResponse<DoctorDTO> update(DoctorDTO doctorDTO) {
        return null;
    }

    @Override
    public CommonResponse<DoctorDTO> search(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<DoctorDTO> delete(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<List<DoctorDTO>> getAll() {
        return null;
    }
}
