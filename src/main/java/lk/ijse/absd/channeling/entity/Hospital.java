package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue
    private int hospitalId;
    private String hospitalName;

    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Doctor> doctors = new ArrayList<>();

    public Hospital() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
