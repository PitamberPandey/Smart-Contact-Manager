package com.src.services.impl;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.Helper.ResourceFoundException;
import com.src.enitities.User;
import com.src.repositories.UserRepo;
import com.src.services.UserServices;
import java.util.UUID;



@Service
public class UserServicesImpl implements UserServices {
@Autowired
    private UserRepo userRepo;
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
    user.setUserId(userId);

        
        
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByid(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
         User user2=userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceFoundException("user not found expection"));
         user2.setName(user.getName());
         user2.setEmail(user.getEmail());
         user2.setPassword(user.getPassword());
         user2.setAbout(user.getAbout());
         user2.setPhoneNumber(user.getPhoneNumber());
         user2.setProfilePic(user.getProfilePic());
         user2.setEnabled(user.isEnabled());
         user2.setEmailVerified(user.isEmailVerified());
         user2.setPhoneVerified(user.isPhoneVerified());
         user2.setProvider(user.getProvider());
         user2.setProviderUserId(user.getProviderUserId());


        //  Update the user
        User save=userRepo.save(user2);
        return Optional.ofNullable(save);


        
    }

    @Override
    public void deleteUser(String id) {
        User user2=userRepo.findById(id).orElseThrow(()->new ResourceFoundException("user not found expection"));
         userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String id) {
        User user2=userRepo.findById(id).orElse(null);
        return user2!=null ? true :false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user2=userRepo.findByEmail(email).orElse(null);
        return user2!=null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepo.findAll();
    }

}