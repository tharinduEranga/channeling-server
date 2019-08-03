package lk.ijse.absd.channeling.dto;

import java.sql.Date;

public class PaymentsDTO {
    private int paymentId;
    private Date date;
    private double amount;

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


}
