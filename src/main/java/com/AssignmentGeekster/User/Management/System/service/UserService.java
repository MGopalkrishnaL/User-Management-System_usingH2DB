package com.AssignmentGeekster.User.Management.System.service;

import com.AssignmentGeekster.User.Management.System.dao.IuserRepository;
import com.AssignmentGeekster.User.Management.System.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService implements IUserService {

    @Autowired
    IuserRepository iuserRepository;
    @Override
    public List<User> getAll(){
        return iuserRepository.findAll();
    }
    @Override
    public User getUsingId(Integer id){

        return iuserRepository.findById(id).get();
    }
    @Override
    public void saveUser(User user1){

        iuserRepository.save(user1);

    }
    @Override
    public String Update(User user){
        iuserRepository.save(user);
     return "User Updated Successfully";
    }
    @Override
    public String deleteUser(Integer userId){
        iuserRepository.deleteById(userId);
        return "User Got Deleted";
    }
}
