package com.code.review.sequrademo.controller;

import com.code.review.sequrademo.usecase.GenerateWeeklyDisbursementsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateWeeklyDisbursementsController {

    @Autowired
    GenerateWeeklyDisbursementsUseCase generateWeeklyDisbursementsUseCase;

    @PutMapping("/disbursements/process")
    void putProcessWeeklyDisbursements(){
        generateWeeklyDisbursementsUseCase.execute();
    }
}
