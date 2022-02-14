package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.model.Fee;
import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.service.DisbursementService;
import com.code.review.sequrademo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.mockito.Mockito.*;

class CompleteOrderUseCaseTest {

    private CompleteOrderUseCase completeOrderUseCase;

    private final OrderService orderService = mock(OrderService.class);
    private final DisbursementService disbursementService = mock(DisbursementService.class);


    private Order oderMock;
    private Disbursement disbursementMock;
    private Fee feeMock;

    @BeforeEach
    void initUseCase() {
        feeMock = new Fee(1,0,50,0.89);
        completeOrderUseCase = new CompleteOrderUseCase(disbursementService, orderService);
    }

    //Set Order to Complete, calculate disbursement and persist
    @Test
    public void setOrderToCompleteAndCreateOrderDisbursementThenPersist() throws Exception {
        Long orderId = 1L;
        Date completedAt = new Date();
        Date createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS").parse("2021-11-10 10:00:00");
        oderMock = new Order(orderId, 1L, 1L, 49.99, createdAt, completedAt);
        disbursementMock = new Disbursement(oderMock.getId(),oderMock.getMerchantId(),oderMock.getWeek(),(oderMock.getAmount()*feeMock.getPercentage())/100,feeMock.getPercentage(),"FAKE");
        when(orderService.completeOrder(orderId, completedAt)).thenReturn(oderMock);
        when(disbursementService.createDisbursementFromOrder(oderMock)).thenReturn(disbursementMock);
        doNothing().when(disbursementService).save(disbursementMock);

        completeOrderUseCase.execute(orderId,completedAt);

        verify(orderService,times(1)).completeOrder(any(), any());
        verify(disbursementService,times(1)).createDisbursementFromOrder(any());
        verify(disbursementService,times(1)).save(any());
    }

}