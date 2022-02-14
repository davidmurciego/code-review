package com.code.review.sequrademo.service;

import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order completeOrder(Long orderId, Date completeAt){
        // TODO: validations
        Order order = orderRepository.get(orderId);
        order.setCreateAt(completeAt);
        orderRepository.save(order);
        return order;
    }

    public List<Order> getLastWeekCompletedOrders(){
        return orderRepository.getLastWeekCompleted();
    }
}
