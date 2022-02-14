package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.service.DisbursementService;
import com.code.review.sequrademo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateWeeklyDisbursementsUseCase {

    DisbursementService disbursementService;
    OrderService orderService;

    public GenerateWeeklyDisbursementsUseCase(DisbursementService disbursementService, OrderService orderService) {
        this.disbursementService = disbursementService;
        this.orderService = orderService;
    }

    /**
     * Get last Week completed Orders List
     * Generate disbursement per order
     * Send to external payment service?
     */
    public void execute(){
        List<Order> lastWeekOrders = orderService.getLastWeekCompletedOrders();
        lastWeekOrders.forEach(order -> {
            Disbursement disbursement = disbursementService.createDisbursementFromOrder(order);
            disbursementService.save(disbursement);
        });
        // TODO: Send to external payment service or publish event
    }
}
