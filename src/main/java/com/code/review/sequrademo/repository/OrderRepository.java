package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Order;

import java.util.List;

public interface OrderRepository {

    Order get(Long id);
    List<Order> getLastWeekCompleted();
    void save(Order order);
}
