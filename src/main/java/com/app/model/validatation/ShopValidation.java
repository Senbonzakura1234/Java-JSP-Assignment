package com.app.model.validatation;

import com.app.jsonmodel.AttributeCreateJsonModel;
import com.app.jsonmodel.Shop.ShopCreateJsonModel;
import com.app.model.returnResult.JsonResult;

public class ShopValidation {
    public static JsonResult validateCreate (ShopCreateJsonModel model){
        if(model.getName().isEmpty() || model.getName() == null)
            return new JsonResult(false, "name is required");
        return new JsonResult(true, "Validate Okay");
    }
}
