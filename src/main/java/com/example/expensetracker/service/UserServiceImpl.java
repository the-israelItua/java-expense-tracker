package com.example.expensetracker.service;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;
import com.example.expensetracker.exceptions.ItemExistsException;
import com.example.expensetracker.exceptions.NotFoundException;
import com.example.expensetracker.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserModel user){
        Boolean existingUser = userRepository.existsByEmail(user.getEmail());
        if(existingUser){
            throw new ItemExistsException("User with this email already exists");
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepository.save(newUser);
    }

    @Override
    public User fetchMe(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User updateUser(User user, String email){
        User userToUpdate = fetchMe(email);
        userToUpdate.setName(user.getName() == null ? userToUpdate.getName() : user.getName());
        userToUpdate.setEmail(user.getEmail() == null ? userToUpdate.getEmail() : user.getEmail());
        userToUpdate.setPassword(user.getPassword() == null ? userToUpdate.getPassword() : user.getPassword());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(String email){
        User userToDelete = fetchMe(email);
        userRepository.delete(userToDelete);
    }
}
