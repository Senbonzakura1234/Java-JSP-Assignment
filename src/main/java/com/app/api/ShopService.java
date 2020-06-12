package com.app.api;
import com.app.context.AttributeBean;
import com.app.context.ShopBean;
import com.app.entity.Attribute;
import com.app.entity.Shop;
import com.app.jsonmodel.AttributeCreateJsonModel;
import com.app.jsonmodel.Shop.ShopCreateJsonModel;
import com.app.model.returnResult.DatabaseQueryResult;
import com.app.model.returnResult.JsonResult;
import com.app.model.validatation.AttributeValidation;
import com.app.model.validatation.ShopValidation;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("/shop")
public class ShopService {

    @EJB
    ShopBean shopBean;

    @POST
    @Path("/create")
    @Produces("application/json")
    @Consumes("application/json")
    public JsonResult addShop (ShopCreateJsonModel model){
        JsonResult validate = ShopValidation.validateCreate(model);
        if(!validate.isSuccess()) return validate;
        Shop shop = new Shop();
        shop.setName(model.getName());
        DatabaseQueryResult result = shopBean.addShop(shop);
        return new JsonResult(result.isSuccess(), result.getDescription());
    }
}
