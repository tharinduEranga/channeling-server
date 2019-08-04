package lk.ijse.absd.channeling.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private int doctorId;
    private String name;
    private String address;
    private String tel;

    @ManyToOne
    @JoinColumn(name = "specialityId")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Doc_days> doc_days = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Appointments> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Admin_doctor> admin_doctors = new ArrayList<>();

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Doc_days> getDoc_days() {
        return doc_days;
    }

    public void setDoc_days(List<Doc_days> doc_days) {
        this.doc_days = doc_days;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public List<Admin_doctor> getAdmin_doctors() {
        return admin_doctors;
    }

    public void setAdmin_doctors(List<Admin_doctor> admin_doctors) {
        this.admin_doctors = admin_doctors;
    }
}
