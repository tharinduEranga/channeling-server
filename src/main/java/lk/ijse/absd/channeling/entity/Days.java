package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Days {
    @Id
    @GeneratedValue
    private int dayId;
    private String day;

    @OneToMany(mappedBy = "days", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Doc_days> doc_days = new ArrayList<>();


    public Days() {
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Doc_days> getDoc_days() {
        return doc_days;
    }

    public void setDoc_days(List<Doc_days> doc_days) {
        this.doc_days = doc_days;
    }


}
