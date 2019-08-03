package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Payments {
    @Id
    @GeneratedValue
    private int paymentId;
    private Date date;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    private Patient patient;

    @OneToMany(mappedBy = "payments", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pay_med> pay_meds = new ArrayList<>();

    public Payments() {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Pay_med> getPay_meds() {
        return pay_meds;
    }

    public void setPay_meds(List<Pay_med> pay_meds) {
        this.pay_meds = pay_meds;
    }
}
