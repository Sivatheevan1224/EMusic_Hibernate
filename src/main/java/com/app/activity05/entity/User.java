package com.app.activity05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) for sql Auto increment if we know
    @GeneratedValue
    @Column(name="user_id")
    private Integer userId; //we cant store null  value here when use wrapper class (Integer) like
    
    @Column(name="first_name")
    private String firstname;
    
    @Column(name="last_name")
    private String lastname;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
