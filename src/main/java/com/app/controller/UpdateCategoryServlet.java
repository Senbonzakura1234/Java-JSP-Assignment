package com.app.controller;

import com.app.context.CategoryBean;
import com.app.entity.Category;
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

@WebServlet(name = "UpdateCategoryServlet", urlPatterns = "/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {
    @EJB
    CategoryBean categoryBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Category category = new Category();
        category.setName(name);
        DatabaseQueryResult DQR = categoryBean.updateCategory(category, id);
        if(DQR.isSuccess()){
            response.sendRedirect("/indexCategory");
        }else {
            doProcess(request, response, DQR.getDescription());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("view/category/update.jsp").forward(request, response);
        doProcess(request, response, "");
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null){
            Category category = categoryBean.getCategory(id);
            if(category != null){
                List<SelectOption> selectOptionList = new ArrayList<>();
                for (Category.StatusEnum item: Category.StatusEnum.values()
                ) {
                    selectOptionList.add(new SelectOption(item.getValue(), item.name(), category.getStatus() == item));
                }
                request.setAttribute("id", category.getId());
                request.setAttribute("name", category.getName());
                request.setAttribute("value", category.getStatus().getValue());
                request.setAttribute("selectOptionList", selectOptionList);
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/category/update.jsp").forward(request, response);
            }else{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
