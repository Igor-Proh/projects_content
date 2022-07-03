package com.prokhnov.projectcontent.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_email")
    private String userEmail;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> userRole;

    @Column(name = "user_is_active")
    private boolean userIsActive;

    public User() {
    }

    public User(String userName, String userSurname, String userEmail/*, Set<Role> userRole*/, boolean userIsActive) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
//        this.userRole = userRole;
        this.userIsActive = userIsActive;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /*
        public Set<Role> getUserRole() {
            return userRole;
        }

        public void setUserRole(Set<Role> userRole) {
            this.userRole = userRole;
        }
    */
    public boolean isUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userIsActive == user.userIsActive && Objects.equals(userName, user.userName) && Objects.equals(userSurname, user.userSurname) && Objects.equals(userEmail, user.userEmail); /*&& Objects.equals(userRole, user.userRole*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, userEmail,/* userRole,*/ userIsActive);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
//                ", userRole=" + userRole +
                ", userIsActive=" + userIsActive +
                '}';
    }
}
