package lk.ijse.absd.channeling.dto;

import java.sql.Time;

public class DaysDTO {
    private int dayId;
    private String day;
    private Time from;
    private Time to;

    public DaysDTO() {
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

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "DaysDTO{" +
                "dayId=" + dayId +
                ", day='" + day + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
