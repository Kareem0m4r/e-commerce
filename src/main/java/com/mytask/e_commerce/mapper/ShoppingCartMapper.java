package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {

    @Mapping(source = "userId", target = "user.userId")
    ShoppingCart toEntity(UserShoppingCartDTO userShoppingCartDTO);

    @Mapping(source = "user.userId", target = "userId")
    UserShoppingCartDTO toDTO (ShoppingCart shoppingCart);

    List<UserShoppingCartDTO> toDTOList(List<ShoppingCart> shoppingCartList);
}
