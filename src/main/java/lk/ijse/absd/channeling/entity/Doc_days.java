package lk.ijse.absd.channeling.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
public class Doc_days {

    @EmbeddedId
    private Doc_days_pk doc_days_pk;
    private Time timeFrom;
    private Time timeTo;

    @ManyToOne
    @JoinColumn(name = "doctorId", insertable = false, updatable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "dayId", insertable = false, updatable = false)
    private Days days;

    public Doc_days() {
    }

    public Doc_days(Time timeFrom, Time timeTo, Doctor doctor, Days days) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.doctor = doctor;
        this.days = days;
        this.doc_days_pk = new Doc_days_pk(doctor.getDoctorId(), days.getDayId());
    }

    public Doc_days_pk getDoc_days_pk() {
        return doc_days_pk;
    }

    public void setDoc_days_pk(Doc_days_pk doc_days_pk) {
        this.doc_days_pk = doc_days_pk;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }


}
