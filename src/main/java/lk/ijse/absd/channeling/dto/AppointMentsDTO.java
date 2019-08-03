package lk.ijse.absd.channeling.dto;

import java.sql.Date;

public class AppointMentsDTO {
    private int appointmentId;
    private Date date;
    private int token_no;
    private String issue;

    public AppointMentsDTO() {
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

}
