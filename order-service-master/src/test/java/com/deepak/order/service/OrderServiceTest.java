package com.deepak.order.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.deepak.order.dto.OrderDTO;
import com.deepak.order.dto.OrderDTOFromFE;
import com.deepak.order.dto.UserDTO;
import com.deepak.order.entity.Order;
import com.deepak.order.mapper.OrderMapper;
import com.deepak.order.repo.OrderRepo;
import com.deepak.order.service.OrderService;
import com.deepak.order.service.SequenceGenerator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private SequenceGenerator sequenceGenerator;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveOrderInDb_shouldSaveOrderAndReturnOrderDTO() {
        // Arrange
        OrderDTOFromFE orderDetails = new OrderDTOFromFE();
        Integer newOrderId = 1;
        UserDTO userDTO = new UserDTO();
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        OrderDTO orderDTOExpected = OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

        when(sequenceGenerator.generateNextOrderId()).thenReturn(newOrderId);
        when(restTemplate.getForObject(anyString(), eq(UserDTO.class))).thenReturn(userDTO);
        when(orderRepo.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        // Act
        OrderDTO orderDTOActual = orderService.saveOrderInDb(orderDetails);

        // Assert
        verify(sequenceGenerator, times(1)).generateNextOrderId();
        assertDoesNotThrow(() -> orderService.saveOrderInDb(orderDetails));
    }
}
