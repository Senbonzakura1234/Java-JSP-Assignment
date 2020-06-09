package com.app.model.validatation;

import com.app.jsonmodel.Category.CategoryCreateJsonModel;
import com.app.model.returnResult.JsonResult;

public class CategoryValidation {

    public static JsonResult validateCreate (CategoryCreateJsonModel model){
        if(model.getName().isEmpty() || model.getName() == null)
            return new JsonResult(false, "name is required");
        return new JsonResult(true, "Validate Okay");
    }
}
