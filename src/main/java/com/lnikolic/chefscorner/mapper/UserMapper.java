package com.lnikolic.chefscorner.mapper;

import com.lnikolic.chefscorner.dto.CreateUser;
import com.lnikolic.chefscorner.dto.UserData;
import com.lnikolic.chefscorner.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userCreateDtoToUser(CreateUser userCreateDto);

    UserData userToUserResponseDto(User user);

    List<UserData> getAllUsers(List<User> users);
}
