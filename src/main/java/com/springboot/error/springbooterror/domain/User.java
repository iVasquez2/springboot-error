package com.springboot.error.springbooterror.domain;

public class User {

    private String name;
    private String lastname;
    private Long id;

    
    public User(Long id, String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }

    
    public User() {
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
