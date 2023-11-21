package com.deepak.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.deepak.userinfo.dto.UserDTO;
import com.deepak.userinfo.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);

}
