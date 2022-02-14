package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.service.DisbursementService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetDisburmentUseCaseTest {

    private GetDisburmentUseCase getDisburmentUseCase;

    private final DisbursementService disbursementService = mock(DisbursementService.class);

    private String week;

    List<Disbursement> disbursementListMock;
    List<Disbursement> emptyDisbursementListMock;

    private int expectedListSize;
    private int expectedEmptyListSize;



    @BeforeEach
    void initUseCase() {
        disbursementListMock = new ArrayList<Disbursement>();
        Disbursement disbursement1 = new Disbursement(1L, 1L, "week", 1.01, 0.01, "FAKE-1");
        Disbursement disbursement2 = new Disbursement(2L, 2L, "week", 2.01, 0.02, "FAKE-2");
        Disbursement disbursement3 = new Disbursement(3L, 3L, "week", 3.01, 0.03, "FAKE-3");
        disbursementListMock.add(disbursement1);
        disbursementListMock.add(disbursement2);
        disbursementListMock.add(disbursement3);
        expectedListSize = disbursementListMock.size();
        emptyDisbursementListMock = new ArrayList<Disbursement>();
        expectedEmptyListSize = emptyDisbursementListMock.size();
        getDisburmentUseCase = new GetDisburmentUseCase(disbursementService);
    }

    @Test
    public void getDisburmentOnlyByWeek() throws Exception {
        week = "202207";
        Optional<Long> merchantId = Optional.empty();
        when(disbursementService.getDisbursementsByWeek(week)).thenReturn(disbursementListMock);

        List<Disbursement> disbursementList = getDisburmentUseCase.get(week, merchantId);

        assertEquals(expectedListSize, disbursementList.size());
    }

    @Test
    public void getDisburmentByWeekAndMerchant() throws Exception {
        week = "202207";
        Optional<Long> merchantId = Optional.of(1L);
        when(disbursementService.getDisbursementsByWeekAndMerchant(week, merchantId.get())).thenReturn(disbursementListMock);

        List<Disbursement> disbursementList = getDisburmentUseCase.get(week, merchantId);

        assertEquals(expectedListSize, disbursementList.size());
    }

    @Test
    public void getEmptyDisburmentByNull() throws Exception {
        week = null;
        Optional<Long> merchantId = Optional.of(1L);
        when(disbursementService.getDisbursementsByWeekAndMerchant(week, merchantId.get())).thenReturn(emptyDisbursementListMock);

        List<Disbursement> disbursementList = getDisburmentUseCase.get(week, merchantId);

        assertEquals(expectedEmptyListSize, disbursementList.size());
    }
}