package ir.maktabsharif.loginandregister.annotations;

import ir.maktabsharif.loginandregister.repository.UsersRepository;
import ir.maktabsharif.loginandregister.repository.impl.UsersRepositoryImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UsersRepository userRepository = new UsersRepositoryImpl();

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null || username.isEmpty()) {
            return true;
        }
        return userRepository.findByUsername(username) == null;
    }

}
