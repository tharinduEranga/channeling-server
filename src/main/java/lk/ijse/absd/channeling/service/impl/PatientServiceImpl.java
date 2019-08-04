package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.PatientDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Patient;
import lk.ijse.absd.channeling.repository.PatientRepository;
import lk.ijse.absd.channeling.service.PatientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse<PatientDTO> add(PatientDTO patientDTO) {
        try {
            Patient patient = modelMapper.map(patientDTO, Patient.class);
            patient = patientRepository.save(patient);
            patientDTO = modelMapper.map(patient, PatientDTO.class);
            return new CommonResponse<>(true, patientDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PatientDTO> update(PatientDTO patientDTO) {
        try {
            if (!patientRepository.findById(patientDTO.getPatientId()).isPresent()) {
                return new CommonResponse<>(false, "Patient not found!");
            }
            return add(patientDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PatientDTO> search(Integer integer) {
        try {
            Optional<Patient> patientById = patientRepository.findById(integer);
            if (!patientById.isPresent()) {
                return new CommonResponse<>(false, "Patient not found!");
            }
            Patient patient = patientById.get();
            PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
            return new CommonResponse<>(true, patientDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PatientDTO> delete(Integer integer) {
        try {
            Optional<Patient> patientById = patientRepository.findById(integer);
            if (!patientById.isPresent()) {
                return new CommonResponse<>(false, "Patient not found!");
            }
            Patient patient = patientById.get();
            patientRepository.delete(patient);
            return new CommonResponse<>(true, "Patient is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<PatientDTO>> getAll() {
        try {
            List<Patient> patientList = patientRepository.findAll();
            Type targetType = new TypeToken<List<PatientDTO>>() {
            }.getType();
            List<PatientDTO> patientDTOS = modelMapper.map(patientList, targetType);
            return new CommonResponse<>(true, patientDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
