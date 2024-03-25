package com.example.userinfo.Controller;

import com.example.userinfo.DTO.UserDTO;
import com.example.userinfo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.addUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> addUser(@PathVariable Long userId){
        return userService.fetchUserDetailsById(userId);
    }

  /* @PostMapping("/fetchUser")
   public ResponseEntity<UserDTO> searchUser(@RequestBody UserRequestDTO credentials){
       return userService.fetchUserDetails(credentials.getUsername(), credentials.getUserpassword());
   }*/


}
