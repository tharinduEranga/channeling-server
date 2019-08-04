package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.MedicineDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Override
    public CommonResponse<MedicineDTO> add(MedicineDTO medicineDTO) {
        return null;
    }

    @Override
    public CommonResponse<MedicineDTO> update(MedicineDTO medicineDTO) {
        return null;
    }

    @Override
    public CommonResponse<MedicineDTO> search(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<MedicineDTO> delete(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse<List<MedicineDTO>> getAll() {
        return null;
    }
}
