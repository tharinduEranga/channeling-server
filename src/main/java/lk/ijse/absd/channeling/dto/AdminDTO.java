package lk.ijse.absd.channeling.dto;

import lk.ijse.absd.channeling.util.Roles;

import javax.persistence.Enumerated;

public class AdminDTO {

    private int adminId;
    private String userName;
    private String password;
    @Enumerated
    private Roles roles;

    public AdminDTO() {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
