package com.code.review.sequrademo.controller;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.service.DisbursementService;
import com.code.review.sequrademo.usecase.GetDisburmentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GetDisbursementsController {

    @Autowired
    GetDisburmentUseCase getDisburmentUseCase;

    @GetMapping(value = {"/disbursements/{week}/{merchantId}","/disbursements/{week}"})
    List<Disbursement> getDisbursementsByWeekAndMerchant(@PathVariable String week, @PathVariable Optional<Long> merchantId){
        //TODO: Return complex data disburment{order{}, merchant{}, shopper{}....}
        return getDisburmentUseCase.get(week, merchantId);
    }
}
