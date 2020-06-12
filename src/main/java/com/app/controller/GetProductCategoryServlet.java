package com.app.controller;

import com.app.context.CategoryBean;
import com.app.context.ProductBean;
import com.app.entity.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetProductCategoryServlet", urlPatterns = "/category")
public class GetProductCategoryServlet extends HttpServlet {
    @EJB
    ProductBean productBean;
    CategoryBean categoryBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null){
            if(categoryBean.getCategory(id) != null){
                List<Product> products = productBean.getProductsOfCategory(id);
                if(products != null){
                    request.setAttribute("products", products);
                    request.getRequestDispatcher("view/category/index.jsp").forward(request, response);
                }else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }

            }else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }


}
