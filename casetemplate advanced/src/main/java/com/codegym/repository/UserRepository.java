package com.codegym.repository;

import com.codegym.model.Order;
import com.codegym.model.User;

public class UserRepository extends DatabaseContext<User>{
    public UserRepository() {
        super(User.class);
        path = "./data/user.txt";
    }

}
