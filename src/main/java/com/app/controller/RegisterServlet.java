package com.app.controller;

import com.app.context.UserBean;
import com.app.entity.User;
import com.app.model.ConstantValue;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @EJB
    UserBean userBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(ConstantValue.TagUsername);
        String email = request.getParameter(ConstantValue.TagEmail);
        String password = request.getParameter(ConstantValue.TagPassword);
        User user = new User(username, email, password);

        if(userBean.addUser(user).isSuccess()){
            HttpSession session = request.getSession();
            session.setAttribute(ConstantValue.TagUsername, user.getUsername());
            response.sendRedirect(ConstantValue.DashboardRoute);
        }else {
            doProgress(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProgress(request, response);
    }
    protected void doProgress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("formRoute", ConstantValue.RegisterRoute);
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }
}
