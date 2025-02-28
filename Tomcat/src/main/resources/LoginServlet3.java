package com.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "password", value = "harsh@28")
        }
)
public class LoginServlet3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pwd = req.getParameter("pwd");
        String password = getServletConfig().getInitParameter("password");

        if (password.equals(pwd)) {
            req.setAttribute("user", "Authenticated User");
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<font color='red'>Invalid password</font>");
            req.getRequestDispatcher("/login.html").include(req, resp);
        }
    }
}
