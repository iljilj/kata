package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.getAll());
        return "users/index";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id", required = false) Long id) {
        User user;
        if (id != null) {
            user = userDao.getById(id);
        } else {
            user = new User();
            user.setId(id);
        }
        model.addAttribute("user", user);

        return "users/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userDao.save(user);
        } else {
            userDao.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user) {
        userDao.delete(user);
        return "redirect:/users";
    }
}
