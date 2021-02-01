package com.project.doit.Web;

import com.project.doit.Colour;
import com.project.doit.DBArticle;
import com.project.doit.DBUser;
import com.project.doit.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class UserLoginController {

    @Autowired
    UserService userService;


// Basic stuff, like greeting page, registration page etc;
    @GetMapping( "/index")
    public String showHome(@RequestParam (name = "name", required = false, defaultValue = " World")String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/register")
    public String showRegForm(DBUser user, Model model){
        model.addAttribute("DBUser", user);
        return "register";
    }

    @PostMapping("/register")
    public @ResponseBody String regDBUser(@ModelAttribute DBUser user, BindingResult result, Model model){
        model.addAttribute("DBUser", user);

        if(result.hasErrors()){
            return "error";
        } else {
            userService.saveUser(user);}
            return "form";
    }
}
