package com.code.review.sequrademo.service;

import com.code.review.sequrademo.model.Fee;
import com.code.review.sequrademo.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeeService {

    @Autowired
    FeeRepository feeRepository;

    public Fee get(double amount){
        return feeRepository.get(amount);
    }

}
