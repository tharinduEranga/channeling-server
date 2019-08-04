package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.DaysDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Days;
import lk.ijse.absd.channeling.repository.DaysRepository;
import lk.ijse.absd.channeling.service.DaysService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class DaysServiceImpl implements DaysService {

    @Autowired
    private DaysRepository daysRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse<DaysDTO> add(DaysDTO daysDTO) {
        try {
            Days days = modelMapper.map(daysDTO, Days.class);
            days = daysRepository.save(days);
            daysDTO = modelMapper.map(days, DaysDTO.class);
            return new CommonResponse<>(true, daysDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<DaysDTO> update(DaysDTO daysDTO) {
        try {
            if (!daysRepository.findById(daysDTO.getDayId()).isPresent()) {
                return new CommonResponse<>(false, "Days not found!");
            }
            return add(daysDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<DaysDTO> search(Integer integer) {
        try {
            Optional<Days> daysById = daysRepository.findById(integer);
            if (!daysById.isPresent()) {
                return new CommonResponse<>(false, "Days not found!");
            }
            Days days = daysById.get();
            DaysDTO daysDTO = modelMapper.map(days, DaysDTO.class);
            return new CommonResponse<>(true, daysDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<DaysDTO> delete(Integer integer) {
        try {
            Optional<Days> daysById = daysRepository.findById(integer);
            if (!daysById.isPresent()) {
                return new CommonResponse<>(false, "Days not found!");
            }
            Days days = daysById.get();
            daysRepository.delete(days);
            return new CommonResponse<>(true, "Days is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<DaysDTO>> getAll() {
        try {
            List<Days> daysList = daysRepository.findAll();
            Type targetType = new TypeToken<List<DaysDTO>>() {
            }.getType();
            List<DaysDTO> daysDTOS = modelMapper.map(daysList, targetType);
            return new CommonResponse<>(true, daysDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
