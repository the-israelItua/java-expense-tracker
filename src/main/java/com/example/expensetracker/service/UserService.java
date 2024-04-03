package com.example.expensetracker.service;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User fetchMe(String email);

    User updateUser(User user, String email);

    void deleteUser(String email);
}
