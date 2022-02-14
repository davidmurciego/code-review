package com.code.review.sequrademo.controller;

import com.code.review.sequrademo.usecase.CompleteOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;

@RestController
public class CompleteOrderController {

    @Autowired
    CompleteOrderUseCase completeOrderUseCase;

    @PostMapping("/order/completed/{orderId}")
    ResponseEntity<Void> postCompleteOrderWithCurrentDate(@PathVariable Long orderId){
        try{
            completeOrderUseCase.execute(orderId, new Date());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            //TODO: logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
