package com.springbootAPI.restfulCRUDapi.Mapper;

import com.springbootAPI.restfulCRUDapi.dto.UserDTO;
import com.springbootAPI.restfulCRUDapi.entity.User;

public class UserMapper {

    public static UserDTO mapUserDto(User user){
        UserDTO userDTO  = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    public static User mapUser(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
