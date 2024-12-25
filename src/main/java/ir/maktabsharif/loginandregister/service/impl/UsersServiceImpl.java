package ir.maktabsharif.loginandregister.service.impl;

import ir.maktabsharif.loginandregister.model.User;
import ir.maktabsharif.loginandregister.model.dto.request.CreateUserRequest;
import ir.maktabsharif.loginandregister.repository.UsersRepository;
import ir.maktabsharif.loginandregister.repository.impl.UsersRepositoryImpl;
import ir.maktabsharif.loginandregister.service.UsersService;

import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository = new UsersRepositoryImpl();

    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .build();
        usersRepository.saveOrUpdate(user);
    }

    @Override
    public User loginUser(String username, String password) {
       return usersRepository.login(username, password);
    }
}
