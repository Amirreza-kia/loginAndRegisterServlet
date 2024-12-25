package ir.maktabsharif.loginandregister.repository;

import ir.maktabsharif.loginandregister.model.User;

public interface UsersRepository extends BaseRepository<User,Long>{

    User login(String username, String password);
}
