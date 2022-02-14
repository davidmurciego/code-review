package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.service.DisbursementService;
import com.code.review.sequrademo.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CompleteOrderUseCase {

    DisbursementService disbursementService;
    OrderService orderService;

    public CompleteOrderUseCase(DisbursementService disbursementService, OrderService orderService) {
        this.disbursementService = disbursementService;
        this.orderService = orderService;
    }

    /**
     * Set Order to Complete, calculate disbursement and persist
     *
     * @param orderId
     * @param completedAt
     */
    public void execute(Long orderId, Date completedAt){
        Order order = orderService.completeOrder(orderId, new Date());
        Disbursement orderDisbursement = disbursementService.createDisbursementFromOrder(order);
        disbursementService.save(orderDisbursement);
        // TODO: Sent orderDisbursement to external Payment Service or wait to Batch disbursement process.
    }


}
