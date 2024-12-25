package ir.maktabsharif.loginandregister.servlet;

import ir.maktabsharif.loginandregister.model.User;
import ir.maktabsharif.loginandregister.service.UsersService;
import ir.maktabsharif.loginandregister.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UsersService usersService = new UsersServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = usersService.loginUser(username,password);
        if(user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("view/loginMenu.jsp");
        }else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
