package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.model.User;

import java.util.List;

public interface UserService {
    UserDTO findDTOById(long id);

    User findEntityById(long id);

    User save(UserDTO userDTO);

   // User update(User user);

    List<UserDTO> findAll();

}
