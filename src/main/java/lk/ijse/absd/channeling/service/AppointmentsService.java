package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.AppointmentsDTO;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentsService extends SuperService<AppointmentsDTO, Integer> {

}
