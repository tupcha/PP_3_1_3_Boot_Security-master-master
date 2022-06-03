package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();
    void saveUser(User user);
    void deletedById(Long id);
    User findById(Long id);
    User loadUserByUsername(String username);

}

