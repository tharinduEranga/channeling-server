package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService extends SuperService<DoctorDTO, Integer> {
}
