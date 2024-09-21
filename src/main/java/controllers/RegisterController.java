package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserModel;
import services.IUserService;
import services.UserService;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        int roleid = Integer.parseInt(req.getParameter("roleid"));

        UserModel newUser = new UserModel();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFullname(fullname);
        newUser.setEmail(email);
        newUser.setRoleid(roleid);

        service.insert(newUser);

        req.setAttribute("alert", "Đăng ký thành công!");
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }
}
