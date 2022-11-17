package com.DigitalVision.service.controllers;

import com.DigitalVision.service.models.UserEntity;
import com.DigitalVision.service.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> userEntities = userService.findAllUsers();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id){
        UserEntity userEntity = userService.findUserById(id);
        return new ResponseEntity<>(userEntity,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
        UserEntity newUser = userService.addUser(userEntity);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateEmployee(@RequestBody UserEntity userEntity){
        UserEntity updateUser = userService.updateUser(userEntity);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<User> addUser()



}
