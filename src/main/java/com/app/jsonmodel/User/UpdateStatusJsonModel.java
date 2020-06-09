package com.app.jsonmodel.User;

import com.app.entity.User;

public class UpdateStatusJsonModel {
    private String id;
    private User.StatusEnum status;

    public UpdateStatusJsonModel() {
    }

    public UpdateStatusJsonModel(String id, User.StatusEnum status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(User.StatusEnum status) {
        this.status = status;
    }
}
