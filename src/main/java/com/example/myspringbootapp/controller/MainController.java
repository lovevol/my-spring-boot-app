package com.example.myspringbootapp.controller;

import com.example.myspringbootapp.properties.MyProperty;
import com.example.myspringbootapp.repository.UserRepository;
import com.example.myspringbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2017-11-30
 * Time: 16:02
 */
@Controller
@RequestMapping("/")
public class MainController {
    private final UserRepository userRepository;
    private final MyProperty myProperty;

    @Autowired
    public MainController(UserRepository userRepository, MyProperty myProperty) {
        this.userRepository = userRepository;
        this.myProperty = myProperty;
    }

    @RequestMapping("/index")
    public String index(){
        return "redirect:/getAll";
    }
    @RequestMapping("/add")
    public  String addUser(User user) {
        userRepository.save(user);
        return "redirect:/getAll";
    }

    @RequestMapping("/getAll")
    public  String getAll(Model model){
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users",users);
        model.addAttribute("myProperty",myProperty);
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
