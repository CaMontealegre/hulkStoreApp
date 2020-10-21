/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.hulkStore.service;

import com.nexos.hulkStore.domain.User;
import com.nexos.hulkStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Montealegre
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getAllUserById(String id) {
        User user = new User();
        return userRepository.findById(id).orElse(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User editUser(User user) {
        User userFind = getAllUserById(user.getId());
        validateEditUser(user, userFind);
        return userRepository.save(userFind);
    }

    protected void validateEditUser(User initial, User end) {
        end.setName(initial.getName());
        end.setEmail(initial.getEmail());
        end.setRol(initial.getRol());
        end.setPass(initial.getPass());
    }
}
