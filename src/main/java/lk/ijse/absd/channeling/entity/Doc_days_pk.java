package lk.ijse.absd.channeling.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Doc_days_pk implements Serializable {
    private int doctorId;
    private int dayId;

    public Doc_days_pk() {
    }

    public Doc_days_pk(int doctorId, int dayId) {
        this.doctorId = doctorId;
        this.dayId = dayId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doc_days_pk that = (Doc_days_pk) o;
        return doctorId == that.doctorId &&
                dayId == that.dayId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(doctorId, dayId);
    }


}
