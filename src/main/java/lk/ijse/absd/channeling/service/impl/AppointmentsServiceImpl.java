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
import lk.ijse.absd.channeling.repository.PatientRepository;
import lk.ijse.absd.channeling.service.AppointmentsService;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
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
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger LOGGER = Logger.getLogger(AppointmentsServiceImpl.class);

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
                int tokenNo = 1;
                List<Appointments> appointmentsByDoctorAndDate = appointmentsRepository
                        .findByDoctorAndDate(doctor, appointmentsDTO.getDate());
                if (appointmentsByDoctorAndDate != null && appointmentsByDoctorAndDate.size() > 0) {
                    tokenNo = tokenNo + appointmentsByDoctorAndDate.get(appointmentsByDoctorAndDate.size() - 1).getToken_no();
                }
                appointments.setToken_no(tokenNo);
                //runs following if condition if the appointment is an update, as its id will be greater than 1
                if (appointments.getAppointmentId() > 0) {
                    appointments.setToken_no(appointmentsDTO.getToken_no());
                }
                appointments = appointmentsRepository.save(appointments);
            } else {
                return new CommonResponse<>(false, "Day is not available for doctor!");
            }

            appointmentsDTO = modelMapper.map(appointments, AppointmentsDTO.class);

            //send sms to appointment booked patient
//            boolean sendSms = SMSHandler.sendSms(appointmentsDTO.getPatient().getTel(), "The token number for appointment at "
//                    + appointmentsDTO.getDate() + " is: " + appointmentsDTO.getToken_no());
//            LOGGER.info("SMS Sens is : " + sendSms);
//            if (!sendSms) {
//                throw new ChannelingException(505, "Failed to send SMS");
//            }
            return new CommonResponse<>(true, appointmentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    @Transactional
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

    @Override
    public CommonResponse<List<AppointmentsDTO>> getFutureAppointments() {
        try {
            Date today = new Date(System.currentTimeMillis());
            List<Appointments> appointmentsList =
                    appointmentsRepository.findAllByDateAfterOrDateOrderByDateAsc(today, today);
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
