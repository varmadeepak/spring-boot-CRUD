package com.springbootAPI.restfulCRUDapi.service;

import com.springbootAPI.restfulCRUDapi.dto.UserDTO;
import com.springbootAPI.restfulCRUDapi.entity.User;

import java.util.List;

public interface UserService {
//    User createUser(User user); // Standard Way

    UserDTO createUser(UserDTO userDTO); // DTO Way
    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long id);
}
