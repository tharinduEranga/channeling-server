package lk.ijse.absd.channeling.dto;

import java.util.List;

public class DoctorDTO {
    private int doctorId;
    private String name;
    private String address;
    private String tel;

    private SpecialityDTO speciality;

    private HospitalDTO hospital;

    private AdminDTO adminDTO;

    private List<DaysDTO> daysDTOs;

    public DoctorDTO() {
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

    public SpecialityDTO getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityDTO speciality) {
        this.speciality = speciality;
    }

    public HospitalDTO getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDTO hospital) {
        this.hospital = hospital;
    }

    public AdminDTO getAdminDTO() {
        return adminDTO;
    }
    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    public List<DaysDTO> getDaysDTOs() {
        return daysDTOs;
    }

    public void setDaysDTOs(List<DaysDTO> daysDTOs) {
        this.daysDTOs = daysDTOs;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", speciality=" + speciality +
                ", hospital=" + hospital +
                ", adminDTO=" + adminDTO +
                ", daysDTOs=" + daysDTOs +
                '}';
    }
}
