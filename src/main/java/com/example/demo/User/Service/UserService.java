package com.example.demo.User.Service;

import com.example.demo.User.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUser();
    User getUser(int id);

    User updateUser(int id, User user);

    User deleteUser(int id);

    User addUser(final User user);

}
