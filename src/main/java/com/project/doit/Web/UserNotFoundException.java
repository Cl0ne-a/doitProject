package com.project.doit.Web;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(int id){
        super("Could not find user " + id);
    }
}
