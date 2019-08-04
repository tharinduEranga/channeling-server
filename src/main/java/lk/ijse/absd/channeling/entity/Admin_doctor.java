package lk.ijse.absd.channeling.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Admin_doctor {

    @EmbeddedId
    private Admin_doctor_pk admin_doctor_pk;

    @ManyToOne
    @JoinColumn(name = "doctorId", insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "adminId", insertable = false, updatable = false)
    private Admin admin;

    public Admin_doctor() {
    }

    public Admin_doctor(Admin admin, Doctor doctor) {
        this.doctor = doctor;
        this.admin = admin;
        this.admin_doctor_pk = new Admin_doctor_pk(admin.getAdminId(), doctor.getDoctorId());
    }

    public Admin_doctor_pk getAdmin_doctor_pk() {
        return admin_doctor_pk;
    }

    public void setAdmin_doctor_pk(Admin_doctor_pk admin_doctor_pk) {
        this.admin_doctor_pk = admin_doctor_pk;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
