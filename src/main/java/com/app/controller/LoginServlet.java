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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @EJB
    UserBean userBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(ConstantValue.TagUsername);
        String password = request.getParameter(ConstantValue.TagPassword);
        User user = userBean.checkLoginInfo(username, password);
        if(user != null){
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
        request.setAttribute("title", ConstantValue.LoginTitle);
        request.setAttribute("formRoute", ConstantValue.LoginRoute);
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }
}
