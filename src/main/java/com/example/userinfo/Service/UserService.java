package com.example.userinfo.Service;

import com.example.userinfo.DTO.UserDTO;
import com.example.userinfo.Entity.User;
import com.example.userinfo.Mapper.UserMapper;
import com.example.userinfo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.UserDTOToUser(userDTO));
        return UserMapper.INSTANCE.UserToUserDTO(savedUser);
    }



    public ResponseEntity<UserDTO> fetchUserDetailsById(Long userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        if(fetchedUser.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.UserToUserDTO(fetchedUser.get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

   /*public ResponseEntity<UserDTO> fetchUserDetails(String username, String userpassword) {
       User fetchedUser = userRepo.findUser(username, userpassword);
       return new ResponseEntity<>(UserMapper.INSTANCE.UserToUserDTO(fetchedUser), HttpStatus.OK);
    }*/
}
