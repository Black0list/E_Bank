package Repositories;

import Entities.User;
import RepositoriesIntf.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    List<User> users = new ArrayList<User>();

    public User save(User user)
    {
        User userSearched = users.stream()
                .filter(userf -> Objects.equals(userf.getFullName(), user.getFullName()))
                .findFirst()
                .orElse(null);

        if(users.remove(userSearched)){
            users.add(user);
        } else {
            users.add(user);
        }

        return user;
    }

    public User findByEmail(String email){
        try{
            return users.stream()
                    .filter(userfound -> Objects.equals(userfound.getEmail(), email))
                    .findFirst()
                    .orElse(null);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<User> all(){
        return users;
    }
}
