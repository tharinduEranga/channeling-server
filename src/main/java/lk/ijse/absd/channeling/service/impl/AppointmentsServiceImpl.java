package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.AppointmentsDTO;
import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Appointments;
import lk.ijse.absd.channeling.entity.Doc_days;
import lk.ijse.absd.channeling.entity.Doctor;
import lk.ijse.absd.channeling.repository.AppointmentRepository;
import lk.ijse.absd.channeling.repository.DocDaysRepository;
import lk.ijse.absd.channeling.repository.DoctorRepository;
import lk.ijse.absd.channeling.service.AppointmentsService;
import org.joda.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    private AppointmentRepository appointmentsRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DocDaysRepository docDaysRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CommonResponse<AppointmentsDTO> add(AppointmentsDTO appointmentsDTO) {
        try {
            Appointments appointments = modelMapper.map(appointmentsDTO, Appointments.class);

            DoctorDTO doctorDTO = appointmentsDTO.getDoctor();
            Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorDTO.getDoctorId());
            if (!optionalDoctor.isPresent()) {
                return new CommonResponse<>(false, "No doctor found!");
            }
            Doctor doctor = optionalDoctor.get();
            List<Doc_days> doc_days = doctor.getDoc_days();

            String[] dateSplitted = String.valueOf(appointmentsDTO.getDate()).split("-");

            int year = Integer.parseInt(dateSplitted[0]);
            int month = Integer.parseInt(dateSplitted[1]);
            int day = Integer.parseInt(dateSplitted[2]);

            boolean isDayAvailable = false;

            String dayName = new LocalDate(year, month, day).dayOfWeek().getAsText();
            for (Doc_days doc_day : doc_days) {
                String docDayName = doc_day.getDays().getDay();
                if (docDayName.equalsIgnoreCase(dayName)) {
                    isDayAvailable = true;
                }
            }
            if (isDayAvailable) {
                appointments = appointmentsRepository.save(appointments);
            } else {
                return new CommonResponse<>(false, "Day is not available for doctor!");
            }
            appointmentsDTO = modelMapper.map(appointments, AppointmentsDTO.class);
            return new CommonResponse<>(true, appointmentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AppointmentsDTO> update(AppointmentsDTO appointmentsDTO) {
        try {
            if (!appointmentsRepository.findById(appointmentsDTO.getAppointmentId()).isPresent()) {
                return new CommonResponse<>(false, "Appointments not found!");
            }
            return add(appointmentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AppointmentsDTO> search(Integer integer) {
        try {
            Optional<Appointments> appointmentsById = appointmentsRepository.findById(integer);
            if (!appointmentsById.isPresent()) {
                return new CommonResponse<>(false, "Appointments not found!");
            }
            Appointments appointments = appointmentsById.get();
            AppointmentsDTO appointmentsDTO = modelMapper.map(appointments, AppointmentsDTO.class);
            return new CommonResponse<>(true, appointmentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AppointmentsDTO> delete(Integer integer) {
        try {
            Optional<Appointments> appointmentsById = appointmentsRepository.findById(integer);
            if (!appointmentsById.isPresent()) {
                return new CommonResponse<>(false, "Appointments not found!");
            }
            Appointments appointments = appointmentsById.get();
            appointmentsRepository.delete(appointments);
            return new CommonResponse<>(true, "Appointments is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<AppointmentsDTO>> getAll() {
        try {
            List<Appointments> appointmentsList = appointmentsRepository.findAll();
            Type targetType = new TypeToken<List<AppointmentsDTO>>() {
            }.getType();
            List<AppointmentsDTO> appointmentsDTOS = modelMapper.map(appointmentsList, targetType);
            return new CommonResponse<>(true, appointmentsDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
