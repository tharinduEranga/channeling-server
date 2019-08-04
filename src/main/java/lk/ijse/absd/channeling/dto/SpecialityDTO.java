package lk.ijse.absd.channeling.dto;

public class SpecialityDTO {

    private int specialityId;
    private String specialityName;

    public SpecialityDTO() {
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public String toString() {
        return "SpecialityDTO{" +
                "specialityId=" + specialityId +
                ", specialityName='" + specialityName + '\'' +
                '}';
    }
}
