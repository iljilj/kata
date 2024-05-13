package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
//    void delete(long id);
    User getById(long id);
    List<User> getAll();
}
