package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private int brandId;
    private String name;

    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Medicine> medicines = new ArrayList<>();

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
