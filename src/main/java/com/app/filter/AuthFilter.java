package com.app.filter;

import com.app.model.ConstantValue;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter" , urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        if (session.getAttribute(ConstantValue.TagUsername) == null) {
            if(uri.contains("assets") || uri.contains("register")) {
                chain.doFilter(req, resp);
                return;
            }
            request.setAttribute("title", ConstantValue.LoginTitle);
            request.setAttribute("formRoute", ConstantValue.LoginRoute);
            RequestDispatcher rd = request.getRequestDispatcher(ConstantValue.LoginRoute);
            rd.forward(request, response);
        }else {
            for(String path : ConstantValue.redirectPath){
                if(uri.contains(path)){
                    RequestDispatcher rd = request.getRequestDispatcher(ConstantValue.DashboardRoute);
                    rd.forward(request, response);
                    return;
                }
            }
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
