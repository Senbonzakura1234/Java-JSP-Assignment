package com.app.api;

import com.app.context.AttributeBean;
import com.app.entity.Attribute;
import com.app.jsonmodel.AttributeCreateJsonModel;
import com.app.model.returnResult.DatabaseQueryResult;
import com.app.model.returnResult.JsonResult;
import com.app.model.validatation.AttributeValidation;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/attribute")
public class AttributeService {
    @EJB
    AttributeBean attributeBean;

    @POST
    @Path("/create")
    @Produces("application/json")
    @Consumes("application/json")
    public JsonResult addCategory (AttributeCreateJsonModel model){
        JsonResult validate = AttributeValidation.validateCreate(model);
        if(!validate.isSuccess()) return validate;
        Attribute attribute = new Attribute();
        attribute.setName(model.getName());
        DatabaseQueryResult result = attributeBean.addAttribute(attribute);
        return new JsonResult(result.isSuccess(), result.getDescription());
    }
}
