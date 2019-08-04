package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.PaymentsDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.service.PaymentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Override
    public CommonResponse<PaymentsDTO> add(PaymentsDTO paymentsDTO) {
        return null;
    }

    @Override
    public CommonResponse<PaymentsDTO> update(PaymentsDTO paymentsDTO) {
        return null;
    }

    @Override
    public CommonResponse<PaymentsDTO> search(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<PaymentsDTO> delete(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<List<PaymentsDTO>> getAll() {
        return null;
    }
}
