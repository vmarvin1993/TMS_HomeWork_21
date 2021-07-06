package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Authorization", urlPatterns = "/authorization")
public class Authorization extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User byUsername = userService.findByUsername(username);
        if (byUsername.getPassword().equals(password)) {
            req.getSession().setAttribute("user", byUsername);
        } else {
            resp.getWriter().print("Wrong password");
        }
    }
}