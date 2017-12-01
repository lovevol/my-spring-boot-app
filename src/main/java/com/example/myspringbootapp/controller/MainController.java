package com.example.myspringbootapp.controller;

import com.example.myspringbootapp.repository.UserRepository;
import com.example.myspringbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return "index";
    }
}
