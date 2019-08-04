package lk.ijse.absd.channeling.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Admin_doctor_pk implements Serializable {

    private int adminId;
    private int doctorId;

    public Admin_doctor_pk() {
    }

    public Admin_doctor_pk(int adminId, int doctorId) {
        this.adminId = adminId;
        this.doctorId = doctorId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin_doctor_pk that = (Admin_doctor_pk) o;
        return adminId == that.adminId &&
                doctorId == that.doctorId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(adminId, doctorId);
    }
}
