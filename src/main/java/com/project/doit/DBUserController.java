package com.project.doit;

import com.project.doit.Web.UserService;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dbuser")
public class DBUserController {

    public UserService userService;
    public UserRepository uRep;


    @GetMapping(value = "/", produces = "application/json")
    public List<DBUser> listUsers() {
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    public DBUser byId(@PathVariable int id){
        DBUser user = uRep.findById(id);
        return user;
    }

    //Filter users by age after
    @GetMapping("{age}")
    public List<DBUser>sortingByAge(@PathVariable(name = "age")int age){
        return userService.byAgeAfter(age);
    }

    //Return list of users, that own more than (some number) of articles

    @GetMapping("count")
    public List<DBUser> userMetInArticleTable(){
        return userService.getUsersThatOwnMoreThanOccArticles();
    }



}
