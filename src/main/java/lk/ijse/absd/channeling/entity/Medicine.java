package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medicine {
    @Id
    @GeneratedValue
    private int medicineId;
    private String medicineName;
    private double price;
    private double qty;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @OneToMany(mappedBy = "medicine", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pay_med> pay_meds = new ArrayList<>();

    public Medicine() {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Pay_med> getPay_meds() {
        return pay_meds;
    }

    public void setPay_meds(List<Pay_med> pay_meds) {
        this.pay_meds = pay_meds;
    }


}
