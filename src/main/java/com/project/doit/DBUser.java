package com.project.doit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DBUser {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String userName;
    @JsonIgnore
    private String userPassword;
    private int age;

    @OneToMany
    private List<DBArticle> list;

    public DBUser() {
    }

    public DBUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public DBUser(String userName, String userPassword , int age) {
        this.userName = userName;
        this.age = age;
        this.userPassword = userPassword;
    }

    public List<DBArticle> getList() {
        return list;
    }

    public void setList(List<DBArticle> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DBUser)) return false;
        DBUser dbUser = (DBUser) o;
        return getId()==(dbUser.getId()) && getUserName().equals(dbUser.getUserName()) && getUserPassword().equals(dbUser.getUserPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getUserPassword());
    }

    @Override
    public String toString() {
        return "DBUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
