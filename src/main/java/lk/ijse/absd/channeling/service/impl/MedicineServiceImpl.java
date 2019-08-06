package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.MedicineDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Medicine;
import lk.ijse.absd.channeling.repository.MedicineRepository;
import lk.ijse.absd.channeling.service.MedicineService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse<MedicineDTO> add(MedicineDTO medicineDTO) {
        try {
            Medicine medicine = modelMapper.map(medicineDTO, Medicine.class);
            medicine = medicineRepository.save(medicine);
            medicineDTO = modelMapper.map(medicine, MedicineDTO.class);
            return new CommonResponse<>(true, medicineDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<MedicineDTO> update(MedicineDTO medicineDTO) {
        try {
            if (!medicineRepository.findById(medicineDTO.getMedicineId()).isPresent()) {
                return new CommonResponse<>(false, "Medicine not found!");
            }
            return add(medicineDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<MedicineDTO> search(Integer integer) {
        try {
            Optional<Medicine> medicineById = medicineRepository.findById(integer);
            if (!medicineById.isPresent()) {
                return new CommonResponse<>(false, "Medicine not found!");
            }
            Medicine medicine = medicineById.get();
            MedicineDTO medicineDTO = modelMapper.map(medicine, MedicineDTO.class);
            return new CommonResponse<>(true, medicineDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<MedicineDTO> delete(Integer integer) {
        try {
            Optional<Medicine> medicineById = medicineRepository.findById(integer);
            if (!medicineById.isPresent()) {
                return new CommonResponse<>(false, "Medicine not found!");
            }
            Medicine medicine = medicineById.get();
            medicineRepository.delete(medicine);
            return new CommonResponse<>(true, "Medicine is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<MedicineDTO>> getAll() {
        try {
            List<Medicine> medicineList = medicineRepository.findAll();
            Type targetType = new TypeToken<List<MedicineDTO>>() {
            }.getType();
            List<MedicineDTO> medicineDTOS = modelMapper.map(medicineList, targetType);
            return new CommonResponse<>(true, medicineDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
