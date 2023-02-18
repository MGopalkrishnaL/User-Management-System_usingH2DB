package com.AssignmentGeekster.User.Management.System.service;

import com.AssignmentGeekster.User.Management.System.model.User;

import java.util.List;

public interface IUserService {
    public List<User> getAll();
    public User getUsingId(Integer id);
    public void saveUser(User user1);

   public String Update(User user);

    public String deleteUser(Integer userId);
}
