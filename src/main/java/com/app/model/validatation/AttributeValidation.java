package com.app.model.validatation;

import com.app.jsonmodel.AttributeCreateJsonModel;
import com.app.model.returnResult.JsonResult;

public class AttributeValidation {
    public static JsonResult validateCreate (AttributeCreateJsonModel model){
        if(model.getName().isEmpty() || model.getName() == null)
            return new JsonResult(false, "name is required");
        return new JsonResult(true, "Validate Okay");
    }
}
