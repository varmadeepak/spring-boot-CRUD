package com.springbootAPI.restfulCRUDapi.Mapper;

import com.springbootAPI.restfulCRUDapi.dto.UserDTO;
import com.springbootAPI.restfulCRUDapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDTO mapUserDto(User user);
    User mapUser(UserDTO userDTO);
}
