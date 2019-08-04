package lk.ijse.absd.channeling.entity;

import lk.ijse.absd.channeling.util.Roles;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class UserRoles {
    @Id
    @GeneratedValue
    private int roleId;
    @Enumerated
    private Roles roles;

    public UserRoles() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
