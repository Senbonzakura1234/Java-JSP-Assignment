package com.app.jsonmodel.User;

import com.app.model.ConstantValue;
import com.app.model.HelperMethod;

import javax.validation.constraints.*;

public class RegisterJsonModel {
    private String username;

    private String password;

    private String email;

    public RegisterJsonModel() {
    }

    public RegisterJsonModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = HelperMethod.removeDotEmail(email);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = HelperMethod.removeDotEmail(email);
    }
}
