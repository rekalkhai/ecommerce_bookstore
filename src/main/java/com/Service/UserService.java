package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Interface.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User getUser(String email,String password) {
        try {
            return repo.findByUserPassword(email,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public User getUserByID(Integer id){
        try {
            return repo.findById(id).get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public User getUserByEmail(String email) {
        try {
            return repo.findByEmail(email);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(User user) { repo.save(user); }
}