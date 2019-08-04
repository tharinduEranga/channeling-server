package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.AppointMentsDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.service.AppointmentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Override
    public CommonResponse<AppointMentsDTO> add(AppointMentsDTO appointMentsDTO) {
        return null;
    }

    @Override
    public CommonResponse<AppointMentsDTO> update(AppointMentsDTO appointMentsDTO) {
        return null;
    }

    @Override
    public CommonResponse<AppointMentsDTO> search(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<AppointMentsDTO> delete(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<List<AppointMentsDTO>> getAll() {
        return null;
    }
}
