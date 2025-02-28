package com.firstservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" }
)
public class LoginServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", req.getParameter("user"));
        req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
    }
}
