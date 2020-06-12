package com.app.controller;

import com.app.context.CategoryBean;
import com.app.context.ProductBean;
import com.app.entity.Category;
import com.app.entity.Product;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateProductServlet", urlPatterns = "/createProduct")
public class CreateProductServlet extends HttpServlet {
    @EJB
    ProductBean productBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        Double price = Double.parseDouble(request.getParameter("price"));
//        String attributeId = request.getParameter("attributeId");
//        String categoryId = request.getParameter("categoryId");
//        String shopId = request.getParameter("shopId");
//        Integer instock = Integer.parseInt(request.getParameter("instock"));
        for(int i=1; i<=10; i++){
            Product product = new Product();
            product.setName("Hello" + i);
            product.setPrice(i*1000);
            product.setAttributeId("1");
            product.setCategoryId("1");
            product.setShopId("1");
            product.setInStock(i);
            DatabaseQueryResult DQR = productBean.addProduct(product);
            System.out.println(DQR.getDescription());
            if(DQR.isSuccess()){
                response.sendRedirect("/indexProduct");
            }else {
                doProcess(request, response, DQR.getDescription());
            }
        }
//        if(name == null || name.isEmpty()){
//            doProcess(request, response, "input is null");
//        }else {
//            Product product = new Product();
//            product.setName(name);
//            product.setPrice(price);
//            product.setAttributeId(attributeId);
//            product.setCategoryId(categoryId);
//            product.setShopId(shopId);
//            product.setInStock(instock);
//            DatabaseQueryResult DQR = productBean.addProduct(product);
//            if(DQR.isSuccess()){
//                response.sendRedirect("/indexCategory");
//            }else {
//                doProcess(request, response, DQR.getDescription());
//            }
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response, "");
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("view/product/create.jsp").forward(request, response);
    }
}

