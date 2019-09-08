package lk.ijse.absd.channeling.service;

import lk.ijse.absd.channeling.dto.AdminDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.dto.util.LoginTokenResponse;
import lk.ijse.absd.channeling.service.main.SuperService;
import org.springframework.stereotype.Service;

@Service
public interface AdminService extends SuperService<AdminDTO, Integer> {
    AdminDTO changePassword(AdminDTO adminDTO);

    CommonResponse<LoginTokenResponse> login(AdminDTO adminDTO);
}
