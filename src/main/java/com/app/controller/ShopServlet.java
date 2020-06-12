package com.app.controller;

import com.app.context.ShopBean;
import com.app.entity.Category;
import com.app.entity.Shop;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "ShopServlet", urlPatterns = "/shops")
public class ShopServlet extends HttpServlet {

    @EJB
    ShopBean shopBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        List<Shop> shops = shopBean.getAllShop("");
        if(shops != null){
            request.setAttribute("shops", shops);
            request.getRequestDispatcher("view/shop/shop.jsp").forward(request, response);
        }else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
