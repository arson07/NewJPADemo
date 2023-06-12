package com.example.demo.User.Service;

import com.example.demo.User.Entity.User;
import com.example.demo.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository  = userRepository;
    }


    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList != null ? userList : Collections.emptyList();
    }


    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User updateUser(int id, User user) {
        Optional<User> existingTicket = userRepository.findById(id);
        if (existingTicket.isPresent()) {
            user.setId(id);
            User result = userRepository.saveAndFlush(user);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public User deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        } else {
            return null;

        }
    }

    @Override
    public User addUser(User userDetails) {
        // Map UserDTO to User entity
        User user = new User();
        user.setId(userDetails.getId());
        user.setName(userDetails.getName());
        user.setBirthDate(userDetails.getBirthDate());

        // Save the User entity to the database
        return userRepository.saveAndFlush(user);
    }
}
