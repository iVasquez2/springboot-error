package com.springboot.error.springbooterror.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.error.springbooterror.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List <User> users;
    //Constructor
    public UserServiceImpl()
    {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Carlos", "Rivera"));
        users.add(new User(2L, "Israel", "Vasquez"));
        users.add(new User(3L, "Jessica", "Suarez"));
        users.add(new User(4L, "Paola", "Xicalhua"));

    }

    @Override
    public User findById(Long id) {
        User user = null;
        for (User u : users)
        {
            if(u.getId().equals(id))
            {
                user = u;
                break;
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
