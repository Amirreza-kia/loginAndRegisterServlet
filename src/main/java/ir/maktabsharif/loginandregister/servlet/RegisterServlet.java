package ir.maktabsharif.loginandregister.servlet;



import ir.maktabsharif.loginandregister.model.dto.request.CreateUserRequest;
import ir.maktabsharif.loginandregister.service.UsersService;
import ir.maktabsharif.loginandregister.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private final UsersService usersService = new UsersServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside doPost register servlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        CreateUserRequest createUserRequest = (CreateUserRequest) request.getAttribute("createUserRequest");
        createUserRequest.setUsername(username);
        createUserRequest.setPassword(password);
        usersService.addUser(createUserRequest);
    }
}
