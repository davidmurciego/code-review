package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Disbursement;

import java.util.List;

public interface DisbursementRepository {
    List<Disbursement> getAllByWeek(String week);
    List<Disbursement> getAllByWeekAndMerchantId(String week, Long merchantId);
    void save(Disbursement disbursement);
}
