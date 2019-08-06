package lk.ijse.absd.channeling.service.impl;

import lk.ijse.absd.channeling.dto.PaymentMedDTO;
import lk.ijse.absd.channeling.dto.PaymentsDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.entity.Medicine;
import lk.ijse.absd.channeling.entity.Pay_med;
import lk.ijse.absd.channeling.entity.Pay_med_pk;
import lk.ijse.absd.channeling.entity.Payments;
import lk.ijse.absd.channeling.repository.MedicineRepository;
import lk.ijse.absd.channeling.repository.PayMedRepository;
import lk.ijse.absd.channeling.repository.PaymentsRepository;
import lk.ijse.absd.channeling.service.PaymentsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lk.ijse.absd.channeling.util.Constants.COMMONERRORMESSAGE;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private PayMedRepository payMedRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CommonResponse<PaymentsDTO> add(PaymentsDTO paymentsDTO) {
        try {
            Payments payments = modelMapper.map(paymentsDTO, Payments.class);
            payments.setDate(Date.valueOf(LocalDate.now()));
            payments = paymentsRepository.save(payments);
            List<Pay_med> pay_meds = new ArrayList<>();
            for (PaymentMedDTO paymentMedDTO : paymentsDTO.getPaymentMedDTOS()) {
                Pay_med pay_med = new Pay_med();
                pay_med.setAmount(paymentMedDTO.getAmount());
                pay_med.setPayments(payments);
                pay_med.setQty(paymentMedDTO.getQty());
                Optional<Medicine> optionalMedicine = medicineRepository.findById(paymentMedDTO.getMedicineId());
                if (optionalMedicine.isPresent()) {
                    Medicine medicine = optionalMedicine.get();
                    pay_med.setMedicine(medicine);
                    medicine.setQty(medicine.getQty() - paymentMedDTO.getQty());
                    pay_med.setPay_med_pk(new Pay_med_pk(medicine.getMedicineId(), payments.getPaymentId()));
                }
                pay_meds.add(pay_med);
            }
            pay_meds = payMedRepository.saveAll(pay_meds);
            paymentsDTO = modelMapper.map(payments, PaymentsDTO.class);
            return new CommonResponse<>(true, paymentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PaymentsDTO> update(PaymentsDTO paymentsDTO) {
        try {
            if (!paymentsRepository.findById(paymentsDTO.getPaymentId()).isPresent()) {
                return new CommonResponse<>(false, "Payments not found!");
            }
            return add(paymentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PaymentsDTO> search(Integer integer) {
        try {
            Optional<Payments> paymentsById = paymentsRepository.findById(integer);
            if (!paymentsById.isPresent()) {
                return new CommonResponse<>(false, "Payments not found!");
            }
            Payments payments = paymentsById.get();
            PaymentsDTO paymentsDTO = modelMapper.map(payments, PaymentsDTO.class);
            return new CommonResponse<>(true, paymentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<PaymentsDTO> delete(Integer integer) {
        try {
            Optional<Payments> paymentsById = paymentsRepository.findById(integer);
            if (!paymentsById.isPresent()) {
                return new CommonResponse<>(false, "Payments not found!");
            }
            Payments payments = paymentsById.get();
            paymentsRepository.delete(payments);
            return new CommonResponse<>(true, "Payments is deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }

    @Override
    public CommonResponse<List<PaymentsDTO>> getAll() {
        try {
            List<Payments> paymentsList = paymentsRepository.findAll();
            Type targetType = new TypeToken<List<PaymentsDTO>>() {
            }.getType();
            List<PaymentsDTO> paymentsDTOS = modelMapper.map(paymentsList, targetType);
            return new CommonResponse<>(true, paymentsDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse<>(false, COMMONERRORMESSAGE + e.getMessage());
        }
    }
}
