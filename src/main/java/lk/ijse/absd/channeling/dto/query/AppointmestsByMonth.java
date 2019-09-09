package lk.ijse.absd.channeling.dto.query;

public class AppointmestsByMonth {
    private String month;
    private long count;
    private int monthNo;

    public AppointmestsByMonth() {
    }

    public AppointmestsByMonth(int monthNo, long count) {
        this.count = count;
        this.monthNo = monthNo;
    }

    public AppointmestsByMonth(String month, long count) {
        this.month = month;
        this.count = count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    @Override
    public String toString() {
        return "AppointmestsByMonth{" +
                "month='" + month + '\'' +
                ", count=" + count +
                ", monthNo=" + monthNo +
                '}';
    }
}
