package com.springboot.error.springbooterror.service;

import java.util.List;

import com.springboot.error.springbooterror.domain.User;

public interface UserService {

    User findById(Long id);
    List <User> findAll();
}
