package com.app.controller;

import com.app.context.AttributeBean;
import com.app.entity.Attribute;
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

@WebServlet(name = "UpdateAttributeServlet", urlPatterns = "/updateAttribute")
public class UpdateAttributeServlet extends HttpServlet {
    @EJB
    AttributeBean attributeBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Attribute attribute = new Attribute();
        attribute.setName(name);
        DatabaseQueryResult DQR = attributeBean.updateAttribute(attribute, id);
        if(DQR.isSuccess()){
            response.sendRedirect("/indexAttribute");
        }else {
            doProcess(request, response, DQR.getDescription());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("view/attribute/update.jsp").forward(request, response);
        doProcess(request, response, "");
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id != null){
            Attribute attribute = attributeBean.getAttribute(id);
            if(attribute != null){
                List<SelectOption> selectOptionList = new ArrayList<>();
                for (Attribute.StatusEnum item: Attribute.StatusEnum.values()
                ) {
                    selectOptionList.add(new SelectOption(item.getValue(), item.name(), attribute.getStatus() == item));
                }
                request.setAttribute("id", attribute.getId());
                request.setAttribute("name", attribute.getName());
                request.setAttribute("value", attribute.getStatus().getValue());
                request.setAttribute("selectOptionList", selectOptionList);
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/attribute/update.jsp").forward(request, response);
            }else{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
