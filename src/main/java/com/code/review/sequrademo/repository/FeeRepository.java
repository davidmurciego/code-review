package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Fee;

public interface FeeRepository {

    Fee get(double orderAmount);
}
