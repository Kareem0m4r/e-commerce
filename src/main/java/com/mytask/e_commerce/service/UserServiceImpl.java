package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.mapper.ShoppingCartMapper;
import com.mytask.e_commerce.mapper.UserMapper;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public UserDTO findDTOById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(new UserDTO());
    }

    @Override
    public User findEntityById(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = userRepository.save(userMapper.toEntity(userDTO));
        return user;
    }

//    @Override
//    public User update(User user) {
//        return userRepository.save(user);
//    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> myUserDTOList = userMapper.toDTOList(userRepository.findAll());
        return myUserDTOList;
    }
}
