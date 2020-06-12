package com.app.controller;

import com.app.context.CategoryBean;
import com.app.context.ShopBean;
import com.app.entity.Category;
import com.app.entity.Shop;
import com.app.model.SelectOption;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateShopServlet", urlPatterns = "/updateShop")
public class UpdateShopServlet extends HttpServlet {
    @EJB
    ShopBean shopBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Shop shop = new Shop();
        shop.setName(name);
        DatabaseQueryResult DQR = shopBean.updateShop(shop, id);
        if(DQR.isSuccess()){
            response.sendRedirect("/shops");
        }else {
            doProcess(request, response, DQR.getDescription());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response, "");
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String id = request.getParameter("1");

        if(id != null){
            Shop shop = shopBean.getShop(id);
            if(shop != null){
                List<SelectOption> selectOptionList = new ArrayList<>();
                for (Category.StatusEnum item: Category.StatusEnum.values()
                ) {
                    selectOptionList.add(new SelectOption(item.getValue(), item.name(), shop.getStatus().equals(item)));
                }
                request.setAttribute("id", shop.getId());
                request.setAttribute("name", shop.getName());
                request.setAttribute("value", shop.getStatus().getValue());
                request.setAttribute("selectOptionList", selectOptionList);
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/shop/update.jsp").forward(request, response);
            }else{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}