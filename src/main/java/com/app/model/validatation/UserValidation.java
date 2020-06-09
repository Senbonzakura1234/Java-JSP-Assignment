package com.app.model.validatation;

import com.app.jsonmodel.User.RegisterJsonModel;
import com.app.jsonmodel.User.UpdatePasswordJsonModel;
import com.app.jsonmodel.User.UpdateStatusJsonModel;
import com.app.model.ConstantValue;
import com.app.model.returnResult.JsonResult;

import java.util.regex.Pattern;

public class UserValidation {

    public static JsonResult validateRegister (RegisterJsonModel model){
        if(model.getPassword().isEmpty() || model.getPassword() == null)
            return new JsonResult(false, "password is required");
        boolean checkPassword = !Pattern.matches(ConstantValue.PasswordRegexRule, model.getPassword());
        if(checkPassword || model.getPassword().length() < 8)
            return new JsonResult(false, "password must have at least 8 characters and " +
                    "password must contain a number, a letter and an unique character");

        return new JsonResult(true, "Validate Okay");
    }

    public static JsonResult validateUpdateStatus (UpdateStatusJsonModel model){
        if(model.getId() == null || model.getId().isEmpty())
            return new JsonResult(false, "input is null");
        return new JsonResult(true, "Validate Okay");
    }

    public static JsonResult validateUpdatePassword(UpdatePasswordJsonModel model){
        if(model.getId() == null || model.getId().isEmpty())
            return new JsonResult(false, "input is null");
        if(model.getNewPassword().equals(model.getOldPassword()))
            return new JsonResult(false, "new password must different to old password");
        boolean checkPassword = !Pattern.matches(ConstantValue.PasswordRegexRule, model.getNewPassword());
        if(checkPassword || model.getNewPassword().length() < 8)
            return new JsonResult(false, "password must have at least 8 characters and " +
                    "password must contain a number, a letter and an unique character");
        return new JsonResult(true, "Validate Okay");
    }
}
