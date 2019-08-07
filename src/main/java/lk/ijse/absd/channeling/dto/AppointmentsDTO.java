package lk.ijse.absd.channeling.dto;

import java.sql.Date;

public class AppointmentsDTO {
    private int appointmentId;
    private Date date;
    private int token_no;
    private String issue;

    private PatientDTO patient;

    private DoctorDTO doctor;

    public AppointmentsDTO() {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getToken_no() {
        return token_no;
    }

    public void setToken_no(int token_no) {
        this.token_no = token_no;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "AppointmentsDTO{" +
                "appointmentId=" + appointmentId +
                ", date=" + date +
                ", token_no=" + token_no +
                ", issue='" + issue + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
