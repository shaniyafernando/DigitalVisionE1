package com.DigitalVision.service.services;

import com.DigitalVision.service.exceptions.UserNotFoundException;
import com.DigitalVision.service.models.UserEntity;
import com.DigitalVision.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserEntity findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by Id "+id
                +" was not found"));
    }
}
