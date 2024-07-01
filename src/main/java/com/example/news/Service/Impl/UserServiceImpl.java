package com.example.news.Service.Impl;


import com.example.news.Entity.User;
import com.example.news.Repository.UserRepository;
import com.example.news.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User save(User user) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPass(passwordEncoder.encode(updatedUser.getPass()));
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }
        return null;
    }


    @Override
    public boolean isUserAdmin(User user) {
        return user != null && user.getRole() != null && user.getRole().equalsIgnoreCase("admin");
    }

    @Override
    public void updateUserPassword(User user, String newPassword) {
        user.setPass(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public User registerUser(User newUser) {
        newUser.setPass(passwordEncoder.encode(newUser.getPass()));
        return userRepository.save(newUser);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPass())) {
            return user;
        }
        return null;
    }
}