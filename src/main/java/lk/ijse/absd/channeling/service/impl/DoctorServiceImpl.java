package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.repository.DoctorRepository;
import lk.ijse.absd.channeling.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse add(DoctorDTO doctorDTO) {
        try {
//            Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
//            doctor = doctorRepository.save(doctor);
//            doctorDTO = modelMapper.map(doctor,DoctorDTO.class);
            return new CommonResponse<>(true, doctorDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse update(DoctorDTO doctorDTO) {
        return null;
    }

    @Override
    public CommonResponse search(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse delete(Integer integer) {
        return null;
    }

    @Override
    public CommonResponse getAll() {
        return null;
    }
}
