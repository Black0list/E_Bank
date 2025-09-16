package RepositoriesIntf;

import Entities.User;

import java.util.Collection;
import java.util.HashSet;

public interface UserRepository {
    void save(User user);
    HashSet<User> all();
}
