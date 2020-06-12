package com.app.controller;

import com.app.context.CategoryBean;
import com.app.entity.Category;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCategoryServlet", urlPatterns = "/createCategory")
public class CreateCategoryServlet extends HttpServlet {
    @EJB
    CategoryBean categoryBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name == null || name.isEmpty()){
            doProcess(request, response, "input is null");
        }else {
            Category category = new Category();
            category.setName(name);
            DatabaseQueryResult DQR = categoryBean.addCategory(category);
            if(DQR.isSuccess()){
                response.sendRedirect("/indexCategory");
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
        request.getRequestDispatcher("view/category/create.jsp").forward(request, response);
    }
}
