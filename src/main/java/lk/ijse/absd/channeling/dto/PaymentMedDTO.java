package lk.ijse.absd.channeling.dto;

public class PaymentMedDTO {
    private int medicineId;
    private double qty;
    private double amount;

    public PaymentMedDTO() {
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
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

    @Override
    public String toString() {
        return "PaymentMedDTO{" +
                "medicineId=" + medicineId +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
