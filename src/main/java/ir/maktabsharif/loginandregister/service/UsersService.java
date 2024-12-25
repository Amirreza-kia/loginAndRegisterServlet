package ir.maktabsharif.loginandregister.service;

import ir.maktabsharif.loginandregister.model.User;
import ir.maktabsharif.loginandregister.model.dto.request.CreateUserRequest;

public interface UsersService {

    void addUser(CreateUserRequest createUserRequest);
    User loginUser(String username, String password);

}
