package com.app.controller;

import com.app.context.AttributeBean;
import com.app.entity.Attribute;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexAttributeServlet",  urlPatterns = "/indexAttribute")
public class IndexAttributeServlet extends HttpServlet {
    @EJB
    AttributeBean attributeBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        List<Attribute> attributes = attributeBean.getAllAttribute(query);
        if(attributes != null){
            request.setAttribute("attributes", attributes);
            request.getRequestDispatcher("view/attribute/index.jsp").forward(request, response);
        }else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
