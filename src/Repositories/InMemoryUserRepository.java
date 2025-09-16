package Repositories;

import Entities.User;
import RepositoriesIntf.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    HashSet<User> users = new HashSet<User>();

    public void save(User user)
    {
        users.add(user);
    }

    public HashSet<User> all(){
        return users;
    }
}
