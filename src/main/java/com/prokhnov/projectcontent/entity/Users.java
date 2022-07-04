package com.prokhnov.projectcontent.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "enabled")
    private int userEnabled;

    public Users() {
    }

    public Users(String userName, String userPassword, int userEnabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEnabled = userEnabled;
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

    public int getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(int userEnabled) {
        this.userEnabled = userEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userName, users.userName) && Objects.equals(userPassword, users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPassword);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEnabled=" + userEnabled +
                '}';
    }
}
