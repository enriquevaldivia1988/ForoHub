package com.forohub.service;

import com.forohub.domain.User;
import com.forohub.dto.UserDTO;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
