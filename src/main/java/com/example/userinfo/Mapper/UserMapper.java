package com.example.userinfo.Mapper;

import com.example.userinfo.DTO.UserDTO;
import com.example.userinfo.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User UserDTOToUser(UserDTO userDTO);
    UserDTO UserToUserDTO(User user);
}
