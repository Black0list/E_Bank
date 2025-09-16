package Services;

import RepositoriesIntf.UserRepository;
import Utils.Validation;
import Entities.User;

import java.util.Collection;
import java.util.HashSet;


public class UserService {
    public UserRepository UserRepo;

    public UserService(UserRepository UserRepo){
        this.UserRepo = UserRepo;
    }

    public void register(String fullName, String email, String password, String address){
        User user = new User(fullName, email, password, address);
        this.UserRepo.save(user);
    }

    public HashSet<User> all(){
        return UserRepo.all();
    }


}
