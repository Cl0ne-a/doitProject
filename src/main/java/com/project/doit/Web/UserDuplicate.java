package com.project.doit.Web;

public class UserDuplicate extends RuntimeException{
    UserDuplicate (String password){
        super ("User with password " + password + " already exists.");
    }
}
