package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Speciality {
    @Id
    @GeneratedValue
    private int specialityId;
    private String specialityName;

    @OneToMany(mappedBy = "speciality", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Doctor> doctors = new ArrayList<>();


    public Speciality() {
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
