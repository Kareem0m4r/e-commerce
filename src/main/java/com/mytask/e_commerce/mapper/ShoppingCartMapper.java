package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.ShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {

    @Mapping(source = "userName", target = "user.userName")
    ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO);

    @Mapping(source = "user.userName", target = "userName")
    ShoppingCartDTO toDTO (ShoppingCart shoppingCart);

    List<ShoppingCartDTO> toDTOList(List<ShoppingCart> shoppingCartList);
}
