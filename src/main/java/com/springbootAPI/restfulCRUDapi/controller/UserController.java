package com.springbootAPI.restfulCRUDapi.controller;

import com.springbootAPI.restfulCRUDapi.Exception.ErrorDetails;
import com.springbootAPI.restfulCRUDapi.Exception.ResourceNotFoundException;
import com.springbootAPI.restfulCRUDapi.dto.UserDTO;
import com.springbootAPI.restfulCRUDapi.entity.User;
import com.springbootAPI.restfulCRUDapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.swing.text.html.HTML;
import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD-REST API",
        description = "Endpoints to create , get , update , delete user details"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "SAVE USER END-POINT",
            description = "SAVE USER END-POINT to save user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP 201 - User Created Successfully"
    )
    @PostMapping("/save")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @Operation(
            summary = "GET USER END-POINT",
            description = "GET USER END-POINT to get user details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP 200 - User fetched Successfully"
    )
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    @Operation(
            summary = "GET ALL USERS END-POINT",
            description = "GET ALL USERS END-POINT to fetch all user details in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP 200 - Users fetched Successfully"
    )
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }


    @Operation(
            summary = "UPDATE USER END-POINT",
            description = "UPDATE USER END-POINT to update user details in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP 200 - User updated Successfully"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id , @RequestBody UserDTO userDTO){

//        user.setId(id);
        userDTO.setId(id);
        UserDTO updatedUser = userService.updateUser(userDTO);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }


    @Operation(
            summary = "DELETE USER END-POINT",
            description = "DELETE USER END-POINT to save delete user details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP 200 - User deleted Successfully"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Delted User Sucessfully", HttpStatus.OK);
    }


}
