package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.HospitalDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Hospital;
import lk.ijse.absd.channeling.repository.HospitalRepository;
import lk.ijse.absd.channeling.service.HospitalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse<HospitalDTO> add(HospitalDTO hospitalDTO) {
        try {
            Hospital hospital = modelMapper.map(hospitalDTO, Hospital.class);
            hospital = hospitalRepository.save(hospital);
            hospitalDTO = modelMapper.map(hospital, HospitalDTO.class);
            return new CommonResponse<>(true, hospitalDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<HospitalDTO> update(HospitalDTO hospitalDTO) {
        try {
            if (!hospitalRepository.findById(hospitalDTO.getHospitalId()).isPresent()) {
                return new CommonResponse<>(false, "Hospital not found!");
            }
            return add(hospitalDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<HospitalDTO> search(Integer integer) {
        try {
            Optional<Hospital> hospitalById = hospitalRepository.findById(integer);
            if (!hospitalById.isPresent()) {
                return new CommonResponse<>(false, "Hospital not found!");
            }
            Hospital hospital = hospitalById.get();
            HospitalDTO hospitalDTO = modelMapper.map(hospital, HospitalDTO.class);
            return new CommonResponse<>(true, hospitalDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<HospitalDTO> delete(Integer integer) {
        try {
            Optional<Hospital> hospitalById = hospitalRepository.findById(integer);
            if (!hospitalById.isPresent()) {
                return new CommonResponse<>(false, "Hospital not found!");
            }
            Hospital hospital = hospitalById.get();
            hospitalRepository.delete(hospital);
            return new CommonResponse<>(true, "Hospital is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<HospitalDTO>> getAll() {
        try {
            List<Hospital> hospitalList = hospitalRepository.findAll();
            Type targetType = new TypeToken<List<HospitalDTO>>() {
            }.getType();
            List<HospitalDTO> hospitalDTOS = modelMapper.map(hospitalList, targetType);
            return new CommonResponse<>(true, hospitalDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
