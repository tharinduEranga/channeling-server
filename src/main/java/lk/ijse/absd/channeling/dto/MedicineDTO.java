package lk.ijse.absd.channeling.dto;

public class MedicineDTO {
    private int medicineId;
    private String medicineName;
    private double price;
    private double qty;

    public MedicineDTO() {
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "MedicineDTO{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
