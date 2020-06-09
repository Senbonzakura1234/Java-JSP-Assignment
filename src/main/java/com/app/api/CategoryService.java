package com.app.api;

import com.app.context.CategoryBean;
import com.app.entity.Category;
import com.app.jsonmodel.Category.CategoryCreateJsonModel;
import com.app.model.returnResult.DatabaseQueryResult;
import com.app.model.returnResult.JsonResult;
import com.app.model.validatation.CategoryValidation;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/category")
public class CategoryService {
    @EJB
    CategoryBean categoryBean;

    @POST
    @Path("/create")
    @Produces("application/json")
    @Consumes("application/json")
    public JsonResult addCategory (CategoryCreateJsonModel model){
        JsonResult validate = CategoryValidation.validateCreate(model);
        if(!validate.isSuccess()) return validate;
        Category category = new Category();
        category.setName(model.getName());
        DatabaseQueryResult result = categoryBean.addCategory(category);
        return new JsonResult(result.isSuccess(), result.getDescription());
    }
}
