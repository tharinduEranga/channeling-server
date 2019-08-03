package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.MedicineDTO;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface MedicineService extends SuperService<MedicineDTO, Integer> {
}
