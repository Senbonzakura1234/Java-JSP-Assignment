package com.app.api;


import com.app.context.UserBean;
import com.app.entity.User;
import com.app.jsonmodel.User.RegisterJsonModel;
import com.app.model.returnResult.DatabaseQueryResult;
import com.app.model.returnResult.JsonResult;
import com.app.model.validatation.UserValidation;

import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("/user")
public class UserService {
    @EJB
    UserBean userBean;

    @POST
    @Path("/register")
    @Produces("application/json")
    @Consumes("application/json")
    public JsonResult register(RegisterJsonModel model){
        JsonResult validate = UserValidation.validateRegister(model);
        if(!validate.isSuccess()) return validate;

        DatabaseQueryResult checkMail = userBean.checkEmail(model.getEmail());
        if(!checkMail.isSuccess()) return new JsonResult(checkMail.isSuccess(), checkMail.getDescription());

        User u = new User();
        u.setUsername(model.getUsername());
        u.setEmail(model.getEmail());
        u.setPassword(model.getPassword());
        DatabaseQueryResult dQR = userBean.addUser(u);
        return new JsonResult(dQR.isSuccess(), dQR.getDescription());
    }

    @POST
    @Path("/delete/{id}")
    @Produces("application/json")
    public JsonResult delete(@PathParam("id") String id){
        DatabaseQueryResult dQR = userBean.deleteUser(id);
        return new JsonResult(dQR.isSuccess(), dQR.getDescription());
    }
//    @POST
//    @Path("/checkEmail")
//    @Produces("application/json")
//    @Consumes("application/json")
//    public String checkEmail(CheckEmailJsonModel model){
//        DatabaseQueryResult dQR = userBean.checkEmail(model.getEmail());
//        return new JsonResult(dQR.isSuccess(), dQR.getDescription());
//        return HelperMethod.removeDotEmail(model.getEmail());
//    }
}
