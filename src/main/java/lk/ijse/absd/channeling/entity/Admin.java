package lk.ijse.absd.channeling.entity;

import lk.ijse.absd.channeling.util.Roles;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private int adminId;
    @Column(unique = true)
    private String userName;
    private String password;
    @Enumerated
    private Roles roles;

    public Admin() {
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
