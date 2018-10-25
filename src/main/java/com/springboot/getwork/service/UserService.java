package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.User;

public interface UserService {

    public User getPersonInfo(User UserModel);
    public List<User> getAll();
    public void registerPerson(User UserModel);
    public User getPersonByUsernamePassword(String username,String password);
}