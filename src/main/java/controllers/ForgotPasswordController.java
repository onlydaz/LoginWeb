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

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim();
        String alertMsg = "";
        
        if (email.isEmpty()) {
            alertMsg = "Email không được để trống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
            return;
        }

        UserModel user = service.findUserByEmail(email);
        if (user != null) {
            alertMsg = "Chọn email thành công!";
            req.setAttribute("alert", alertMsg);
        } else {
            alertMsg = "Email không tồn tại!";
            req.setAttribute("alert", alertMsg);
        }
        req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
    }

}
