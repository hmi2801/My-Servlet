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
                @WebInitParam(name = "user", value = "harsh")
        }
)
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String userID = getServletConfig().getInitParameter("user");

        if (userID.equals(user)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<font color='red'>Invalid username</font>");
            req.getRequestDispatcher("/login.html").include(req, resp);
        }
    }
}
