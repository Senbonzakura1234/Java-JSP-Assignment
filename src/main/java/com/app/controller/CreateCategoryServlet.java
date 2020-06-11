package com.app.controller;

import com.app.context.CategoryBean;
import com.app.entity.Category;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
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
            doProcess(request, response);
        }else {
            Category category = new Category();
            category.setName(name);
            if(categoryBean.addCategory(category).isSuccess()){
                response.sendRedirect("/categories");
            }else {
                doProcess(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/category/create.jsp").forward(request, response);
    }
}
