package lk.ijse.absd.channeling.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDTO {
    private int paymentId;
    private Date date;
    private double amount;

    private PatientDTO patient;

    private List<PaymentMedDTO> paymentMedDTOS = new ArrayList<>();

    public PaymentsDTO() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public List<PaymentMedDTO> getPaymentMedDTOS() {
        return paymentMedDTOS;
    }

    public void setPaymentMedDTOS(List<PaymentMedDTO> paymentMedDTOS) {
        this.paymentMedDTOS = paymentMedDTOS;
    }

    @Override
    public String toString() {
        return "PaymentsDTO{" +
                "paymentId=" + paymentId +
                ", date=" + date +
                ", amount=" + amount +
                ", patient=" + patient +
                ", paymentMedDTOS=" + paymentMedDTOS +
                '}';
    }
}
