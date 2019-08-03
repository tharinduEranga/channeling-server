package lk.ijse.absd.channeling.dto;

public class HospitalDTO {
    private int hospitalId;
    private String hospital;

    public HospitalDTO() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "HospitalDTO{" +
                "hospitalId=" + hospitalId +
                ", hospital='" + hospital + '\'' +
                '}';
    }
}
