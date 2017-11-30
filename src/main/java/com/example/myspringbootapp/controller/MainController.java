package com.example.myspringbootapp.controller;

import com.example.myspringbootapp.repository.UserRepository;
import com.example.myspringbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2017-11-30
 * Time: 16:02
 */
@Controller
@RequestMapping("/spring")
public class MainController {
    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/add")
    public  @ResponseBody String addUser(@RequestParam String name,
                                         @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @RequestMapping("/getAll")
    public  @ResponseBody Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping("/error")
    public String error(){
        return "index";
    }
}
