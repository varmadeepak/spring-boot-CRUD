package com.springbootAPI.restfulCRUDapi.service;

import com.springbootAPI.restfulCRUDapi.Exception.EmailAlreadyExistsException;
import com.springbootAPI.restfulCRUDapi.Exception.ResourceNotFoundException;
import com.springbootAPI.restfulCRUDapi.Mapper.AutoUserMapper;
import com.springbootAPI.restfulCRUDapi.Mapper.UserMapper;
import com.springbootAPI.restfulCRUDapi.dto.UserDTO;
import com.springbootAPI.restfulCRUDapi.entity.User;
import com.springbootAPI.restfulCRUDapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;


    @Override
    public UserDTO createUser(UserDTO userDTO) {

//        User createdUser = new User(
//          userDTO.getId(),
//          userDTO.getFirstName(),
//          userDTO.getLastName(),
//          userDTO.getEmail()
//        );
//        User createdUser = UserMapper.mapUser(userDTO);

        Optional<User> optionalUser = userRepo.findByEmail(userDTO.getEmail());
        if( optionalUser.isPresent() ){
            throw new EmailAlreadyExistsException("A User with this email : " + userDTO.getEmail() + " Already Exists");

        }
        User createdUser = AutoUserMapper.MAPPER.mapUser(userDTO);
        User savedUser = userRepo.save(createdUser);

//        UserDTO savedUserDto = new UserDTO(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );
//        UserDTO savedUserDto = UserMapper.mapUserDto(savedUser);
        return AutoUserMapper.MAPPER.mapUserDto(savedUser);
//        return userRepo.save(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","Id",id)
        );
        return AutoUserMapper.MAPPER.mapUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for(int i = 0; i<userDTOList.size(); i++){
//            userDTOList.add(UserMapper.mapUserDto(userList.get(i)));
//        }

//        return userRepo.findAll();
        return userList.stream().map(AutoUserMapper.MAPPER::mapUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO  userDTO) {
        User nonDTO = AutoUserMapper.MAPPER.mapUser(userDTO);
        User existingUser = userRepo.findById(nonDTO.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",nonDTO.getId())
        );
        existingUser.setEmail(existingUser.getEmail());
        existingUser.setFirstName(existingUser.getFirstName());
        existingUser.setLastName(existingUser.getLastName());
        User updatedUser  =  userRepo.save(existingUser);
//        UserDTO dtoUser = UserMapper.mapUserDto(updatedUser);
        return AutoUserMapper.MAPPER.mapUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",id)
        );
        userRepo.deleteById(id);
    }
}
