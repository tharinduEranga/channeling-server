package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.AdminDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Admin;
import lk.ijse.absd.channeling.repository.AdminRepository;
import lk.ijse.absd.channeling.service.AdminService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class);

    @Override
    public CommonResponse<AdminDTO> add(AdminDTO adminDTO) {
        try {
            Admin byUserName = adminRepository.findByUserName(adminDTO.getUserName());
            if (byUserName != null) {
                return new CommonResponse<>(false, "The username is already added!");
            }
            Admin admin = modelMapper.map(adminDTO, Admin.class);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin = adminRepository.save(admin);
            adminDTO = modelMapper.map(admin, AdminDTO.class);
            return new CommonResponse<>(true, adminDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AdminDTO> update(AdminDTO adminDTO) {
        try {
            if (!adminRepository.findById(adminDTO.getAdminId()).isPresent()) {
                return new CommonResponse<>(false, "Admin not found!");
            }
            LOGGER.info("Admin service: " + adminDTO);
            Admin admin = modelMapper.map(adminDTO, Admin.class);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin = adminRepository.save(admin);
            return new CommonResponse<>(true, adminDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AdminDTO> search(Integer integer) {
        try {
            Optional<Admin> adminById = adminRepository.findById(integer);
            if (!adminById.isPresent()) {
                return new CommonResponse<>(false, "Admin not found!");
            }
            Admin admin = adminById.get();
            AdminDTO adminDTO = modelMapper.map(admin, AdminDTO.class);
            return new CommonResponse<>(true, adminDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<AdminDTO> delete(Integer integer) {
        try {
            Optional<Admin> adminById = adminRepository.findById(integer);
            if (!adminById.isPresent()) {
                return new CommonResponse<>(false, "Admin not found!");
            }
            Admin admin = adminById.get();
            adminRepository.delete(admin);
            return new CommonResponse<>(true, "Admin is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<AdminDTO>> getAll() {
        try {
            List<Admin> adminList = adminRepository.findAll();
            Type targetType = new TypeToken<List<AdminDTO>>() {
            }.getType();
            List<AdminDTO> adminDTOS = modelMapper.map(adminList, targetType);
            return new CommonResponse<>(true, adminDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public AdminDTO changePassword(AdminDTO adminDTO) {
        return null;
    }
}
