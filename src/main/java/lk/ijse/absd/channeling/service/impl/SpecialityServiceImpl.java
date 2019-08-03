package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.SpecialityDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Speciality;
import lk.ijse.absd.channeling.repository.SpecialityRepository;
import lk.ijse.absd.channeling.service.SpecialityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public CommonResponse add(SpecialityDTO specialityDTO) {
        try {
            Speciality speciality = modelMapper.map(specialityDTO, Speciality.class);
            speciality = specialityRepository.save(speciality);
            specialityDTO = modelMapper.map(speciality, SpecialityDTO.class);
            return new CommonResponse<>(true, specialityDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse update(SpecialityDTO specialityDTO) {
        try {
            if (!specialityRepository.findById(specialityDTO.getSpecialityId()).isPresent()) {
                return new CommonResponse(false, "Speciality not found!");
            }
            return add(specialityDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse search(Integer integer) {
        try {
            Optional<Speciality> specialityById = specialityRepository.findById(integer);
            if (!specialityById.isPresent()) {
                return new CommonResponse(false, "Speciality not found!");
            }
            Speciality speciality = specialityById.get();
            SpecialityDTO specialityDTO = modelMapper.map(speciality, SpecialityDTO.class);
            return new CommonResponse<>(true, specialityDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse delete(Integer integer) {

        try {
            Optional<Speciality> specialityById = specialityRepository.findById(integer);
            if (!specialityById.isPresent()) {
                return new CommonResponse(false, "Speciality not found!");
            }
            Speciality speciality = specialityById.get();
            specialityRepository.delete(speciality);
            return new CommonResponse<>(true, "Speciality is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse getAll() {
        try {
            List<Speciality> specialityList = specialityRepository.findAll();
            Type targetType = new TypeToken<List<SpecialityDTO>>() {
            }.getType();
            List<SpecialityDTO> specialityDTOS = modelMapper.map(specialityList, targetType);
            return new CommonResponse<>(true, specialityDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
