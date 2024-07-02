package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "userId", target = "user.userId")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "user.userId", target = "userId")
    OrderDTO toDTO (Order order);

    List<OrderDTO> toDTOList(List<Order> orderList);
}
