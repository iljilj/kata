package com.example.dao;


import com.example.model.User;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    void deleteById(int id);
    User getById(Long id);
    List<User> getAll();


}
