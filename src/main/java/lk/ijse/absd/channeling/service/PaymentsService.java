package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.PaymentsDTO;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface PaymentsService extends SuperService<PaymentsDTO, Integer> {
}
