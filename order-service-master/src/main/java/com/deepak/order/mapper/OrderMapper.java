package com.deepak.order.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.deepak.order.dto.OrderDTO;
import com.deepak.order.entity.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}
