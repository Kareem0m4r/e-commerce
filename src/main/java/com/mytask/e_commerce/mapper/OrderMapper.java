package com.mytask.e_commerce.mapper;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDTO orderDTO);

    OrderDTO toDTO (Order order);

    List<Order> toDTOList(List<Order> orderList);
}
