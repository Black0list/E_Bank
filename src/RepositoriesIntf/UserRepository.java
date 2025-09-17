package RepositoriesIntf;

import Entities.User;

import java.util.List;
import java.util.Collection;
import java.util.HashSet;

public interface UserRepository {
    User save(User user);
    List<User> all();
    User findByEmail(String email);
}
