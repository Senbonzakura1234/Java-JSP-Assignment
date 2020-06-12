package com.app.controller;

import com.app.context.AttributeBean;
import com.app.entity.Attribute;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAttributeServlet", urlPatterns = "/createAttribute")
public class CreateAttributeServlet extends HttpServlet {
    @EJB
    AttributeBean attributeBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name == null || name.isEmpty()){
            doProcess(request, response, "input is null");
        }else {
            Attribute attribute = new Attribute();
            attribute.setName(name);
            DatabaseQueryResult DQR = attributeBean.addAttribute(attribute);
            if(DQR.isSuccess()){
                response.sendRedirect("/indexAttribute");
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
        request.getRequestDispatcher("view/attribute/create.jsp").forward(request, response);
    }
}
