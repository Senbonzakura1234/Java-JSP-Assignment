package com.app.controller;

import com.app.context.ShopBean;
import com.app.entity.Shop;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateShopServlet", urlPatterns = "/createShop")
public class CreateShopServlet extends HttpServlet {
    @EJB
    ShopBean shopBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name == null || name.isEmpty()){
            doProcess(request, response, "input is null");
        }else {
            Shop shop = new Shop();
            shop.setName(name);
            shop.setUpdatedAt((long) 11111);
            shop.setCreatedAt((long) 11111);
            shop.setId("1");
            shop.setStatus(Shop.StatusEnum.ACTIVE);
            DatabaseQueryResult DQR = shopBean.addShop(shop);
            if(DQR.isSuccess()){
                response.sendRedirect("/shops");
            }else {
                doProcess(request, response, DQR.getDescription());
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response, "");
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("view/shop/create.jsp").forward(request, response);
    }
}
