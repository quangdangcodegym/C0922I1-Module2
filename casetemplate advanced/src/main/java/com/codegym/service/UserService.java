package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.getAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.find(id);
    }
}
