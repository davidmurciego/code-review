package com.code.review.sequrademo.service;

import com.code.review.sequrademo.model.DisburStates;
import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.model.Fee;
import com.code.review.sequrademo.model.Order;
import com.code.review.sequrademo.repository.DisbursementRepository;
import com.code.review.sequrademo.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DisbursementService {

    @Autowired
    DisbursementRepository disbursementRepository;
    @Autowired
    FeeService feeService;

    public List<Disbursement> getDisbursementsByWeekAndMerchant(String week, Long merchantId){
        List<Disbursement> disbursements = disbursementRepository.getAllByWeekAndMerchantId(week, merchantId);
        return disbursements;
    }

    public List<Disbursement> getDisbursementsByWeek(String week){
        List<Disbursement> disbursements = disbursementRepository.getAllByWeek(week);
        return disbursements;
    }

    public Disbursement createDisbursementFromOrder(Order order){
        Fee orderFee = feeService.get(order.getAmount());
        Disbursement orderDisbursement = new Disbursement(
                order.getId(),
                order.getMerchantId(),
                order.getWeek(),
                calculateDisburs(order.getAmount(),orderFee.getPercentage()),
                orderFee.getPercentage(),
                DisburStates.PENDING_SENT.toString()
        );
        return orderDisbursement;
    }

    public void save(Disbursement disbursement){
        disbursementRepository.save(disbursement);
    }

    private double calculateDisburs(double orderAmount, double feePercentage){
        return ( orderAmount * feePercentage ) / 100;
    }
}
