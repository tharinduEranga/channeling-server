package lk.ijse.absd.channeling.dto.util;

import lk.ijse.absd.channeling.dto.AdminDTO;

public class LoginTokenResponse {
    private AdminDTO admin;
    private String token;

    public LoginTokenResponse() {
    }

    public LoginTokenResponse(AdminDTO admin, String token) {
        this.admin = admin;
        this.token = token;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginTokenResponse{" +
                "admin=" + admin +
                ", token='" + token + '\'' +
                '}';
    }
}
