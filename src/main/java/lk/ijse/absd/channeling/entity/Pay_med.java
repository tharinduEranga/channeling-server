package lk.ijse.absd.channeling.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pay_med {

    @EmbeddedId
    private Pay_med_pk pay_med_pk;
    private double qty;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "medicineId", insertable = false, updatable = false)
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "paymentId", insertable = false, updatable = false)
    private Payments payments;

    public Pay_med() {
    }

    public Pay_med(double qty, double amount, Medicine medicine, Payments payments) {
        this.qty = qty;
        this.amount = amount;
        this.medicine = medicine;
        this.payments = payments;
        this.pay_med_pk = new Pay_med_pk(medicine.getMedicineId(), payments.getPaymentId());
    }

    public Pay_med_pk getPay_med_pk() {
        return pay_med_pk;
    }

    public void setPay_med_pk(Pay_med_pk pay_med_pk) {
        this.pay_med_pk = pay_med_pk;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

}
