package com.example.milandemo.Controller;


import com.example.milandemo.Model.User;
import com.example.milandemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/")

public class UserController {
    public final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("registration")
    public String showRegForm(User user){
        System.out.println("/users/registration");
        return "add-user";
    }

    @PostMapping("add")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-user";
        }
        userRepository.save(user);
        return "redirect:list";
    }


    @GetMapping("list")
    public String showAll(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "list";
    }

    @GetMapping("edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid student id: "+id));
        model.addAttribute("user",user);
        return "add-user";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user, BindingResult result , Model model){
        if(result.hasErrors()){
            user.setId(id);
            return "update-users";
        }
        userRepository.save(user);
        model.addAttribute("users",userRepository.findAll());
        return "redirect:list";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Student Id: "+id));
        userRepository.delete(user);
        model.addAttribute("users",userRepository.findAll());
        return "list";
    }
}
