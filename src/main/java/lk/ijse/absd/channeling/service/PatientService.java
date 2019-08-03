package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.PatientDTO;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface PatientService extends SuperService<PatientDTO, Integer> {
}
