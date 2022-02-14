package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.model.Fee;
import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.service.DisbursementService;
import com.code.review.sequrademo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class GenerateWeeklyDisbursementsTest {

    private GenerateWeeklyDisbursementsUseCase generateWeeklyDisbursementsUseCase;

    private final OrderService orderService = mock(OrderService.class);
    private final DisbursementService disbursementService = mock(DisbursementService.class);

    private List<Order> completedOrdersListMock;
    private int expectedListSize;

    @BeforeEach
    void initUseCase() throws ParseException {
        Date createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS").parse("2021-11-10 10:00:00");
        Date completedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS").parse("2022-02-14 10:00:00");
        completedOrdersListMock = new ArrayList<Order>();
        Order order1 = new Order(1L, 1L, 1L, 49.99, createdAt,completedAt);
        Order order2 = new Order(2L, 2L, 2L, 79.99, createdAt,completedAt);
        Order order3 = new Order(3L, 3L, 3L, 99.99, createdAt,completedAt);
        completedOrdersListMock.add(order1);
        completedOrdersListMock.add(order2);
        completedOrdersListMock.add(order3);
        expectedListSize = completedOrdersListMock.size();
        generateWeeklyDisbursementsUseCase = new GenerateWeeklyDisbursementsUseCase(disbursementService, orderService);
    }

    @Test
    public void getCompletedOrdersListAndCreateDisbursementPerOrder() throws Exception {
        Disbursement disbursementMock = new Disbursement(1L, 1L, "week", 1.01, 0.01, "FAKE-1");
        when(orderService.getLastWeekCompletedOrders()).thenReturn(completedOrdersListMock);
        when(disbursementService.createDisbursementFromOrder(completedOrdersListMock.get(0))).thenReturn(disbursementMock);

        generateWeeklyDisbursementsUseCase.execute();

        assertEquals(expectedListSize, completedOrdersListMock.size());
        verify(orderService,times(1)).getLastWeekCompletedOrders();
        verify(disbursementService,times(expectedListSize)).createDisbursementFromOrder(any());
        verify(disbursementService,times(expectedListSize)).save(any());
    }
}
