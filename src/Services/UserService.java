package Services;

import Main.Main;
import RepositoriesIntf.UserRepository;
import Utils.Validation;
import Entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;


public class UserService {
    public UserRepository UserRepo;

    public UserService(UserRepository UserRepo){
        this.UserRepo = UserRepo;
    }

    public void register(String fullName, String email, String password, String address){
        User user = new User(fullName, email, password, address);
        this.UserRepo.save(user);
    }

    public User login(String email, String password){
        User user =  this.UserRepo.findByEmail(email);
        if(Objects.isNull(user)){
            return null;
        }else if(Objects.equals(user.getPassword(), password)) {
            System.out.println("Successfully Logged in");
            return user;
        }

        return null;
    }

    public User updateEmail(String email){
        User user = this.UserRepo.findByEmail(Main.USER.getEmail());
        user.setEmail(email);
        System.out.println("Email Updated Successfully");
        return this.UserRepo.save(user);
    }

    public User updateAddress(String address){
        User user = this.UserRepo.findByEmail(Main.USER.getEmail());
        user.setAddress(address);
        System.out.println("Address Updated Successfully");
        return this.UserRepo.save(user);
    }

    public boolean checkPassword(String password){
        User user = this.UserRepo.findByEmail(Main.USER.getEmail());
        return Objects.equals(user.getPassword(), password);
    }

    public User updatePassword(String password){
        User user = this.UserRepo.findByEmail(Main.USER.getEmail());
        if(Validation.checkPassword(password)){
            user.setPassword(password);
            System.out.println("Password Updated Successfully");
            return this.UserRepo.save(user);
        } else {
            System.out.println("Password Must be at Least 6 characters");
            return user;
        }

    }

    public List<User> all(){
        return UserRepo.all();
    }


}
