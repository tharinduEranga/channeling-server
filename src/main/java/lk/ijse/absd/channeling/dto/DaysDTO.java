package lk.ijse.absd.channeling.dto;

public class DaysDTO {
    private int dayId;
    private String day;

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

    @Override
    public String toString() {
        return "DaysDTO{" +
                "dayId=" + dayId +
                ", day='" + day + '\'' +
                '}';
    }
}
