package com.example.news.Service;

import com.example.news.Entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User update(Long id, User updatedUser);
    boolean isUserAdmin(User user);
    void updateUserPassword(User user, String newPassword);
    User registerUser(User newUser);
    User loginUser(String username, String password);

}
