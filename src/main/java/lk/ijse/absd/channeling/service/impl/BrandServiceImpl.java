package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.BrandDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Brand;
import lk.ijse.absd.channeling.repository.BrandRepository;
import lk.ijse.absd.channeling.service.BrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse add(BrandDTO brandDTO) {
        try {
            Brand brand = modelMapper.map(brandDTO, Brand.class);
            brand = brandRepository.save(brand);
            brandDTO = modelMapper.map(brand, BrandDTO.class);
            return new CommonResponse<>(true, brandDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse update(BrandDTO brandDTO) {
        try {
            if (!brandRepository.findById(brandDTO.getBrandId()).isPresent()) {
                return new CommonResponse(false, "Brand not found!");
            }
            return add(brandDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse search(Integer integer) {
        try {
            Optional<Brand> brandById = brandRepository.findById(integer);
            if (!brandById.isPresent()) {
                return new CommonResponse(false, "Brand not found!");
            }
            Brand brand = brandById.get();
            BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
            return new CommonResponse<>(true, brandDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse delete(Integer integer) {
        try {
            Optional<Brand> brandById = brandRepository.findById(integer);
            if (!brandById.isPresent()) {
                return new CommonResponse(false, "Brand not found!");
            }
            Brand brand = brandById.get();
            brandRepository.delete(brand);
            return new CommonResponse<>(true, "Brand is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse getAll() {
        try {
            List<Brand> brandList = brandRepository.findAll();
            Type targetType = new TypeToken<List<BrandDTO>>() {
            }.getType();
            List<BrandDTO> brandDTOS = modelMapper.map(brandList, targetType);
            return new CommonResponse<>(true, brandDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
