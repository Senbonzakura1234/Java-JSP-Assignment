package com.app.controller;

import com.app.context.CategoryBean;
import com.app.entity.Category;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexCategoryServlet",  urlPatterns = "/indexCategory")
public class IndexCategoryServlet extends HttpServlet {

    @EJB
    CategoryBean categoryBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        List<Category> categories = categoryBean.getAllCategory(query);
        if(categories != null){
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("view/category/index.jsp").forward(request, response);
        }else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
