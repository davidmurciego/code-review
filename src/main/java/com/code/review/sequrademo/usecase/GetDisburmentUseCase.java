package com.code.review.sequrademo.usecase;

import com.code.review.sequrademo.model.Disbursement;
import com.code.review.sequrademo.service.DisbursementService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetDisburmentUseCase {

    DisbursementService disbursementService;

    public GetDisburmentUseCase(DisbursementService disbursementService) {
        this.disbursementService = disbursementService;
    }

    /**
     * Get Disbursment by Week and optional Merchant
     * @param week (Format yyyyww)
     * @param merchantId
     * @return
     */
    public List<Disbursement> get(String week, Optional<Long> merchantId){
        try{
            List<Disbursement> disbursements;
            if (merchantId.isPresent()){
                disbursements = disbursementService.getDisbursementsByWeekAndMerchant(week, merchantId.get());
            }else{
                disbursements = disbursementService.getDisbursementsByWeek(week);
            }
            return disbursements;
        }catch (Exception e){
            // TODO: logger.error()
            return new ArrayList<>();
        }

    }


}
