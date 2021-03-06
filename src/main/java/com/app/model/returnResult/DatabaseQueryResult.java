package com.app.model.returnResult;

public class DatabaseQueryResult {
    private boolean Success;
    private String Description;

    public DatabaseQueryResult(boolean success, String description) {
        Success = success;
        Description = description;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
