package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDTO (User user);
    List<UserDTO> toDTOList(List<User> userList);
}
