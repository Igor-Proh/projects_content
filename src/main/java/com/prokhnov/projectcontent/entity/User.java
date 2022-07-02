package com.prokhnov.projectcontent.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userSurname")
    private String userSurname;

    @Column(name = "userEmail")
    private String userEmail;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> userRole;

    @Column(name = "userIsActive")
    private boolean userIsActive;

}
