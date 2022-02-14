package com.code.review.sequrademo.model;

import java.util.Date;

public class Order {

    private Long id;
    private Long merchantId;
    private Long shopperId;
    private double amount;
    private Date createAt;
    private Date completedAt;

    public Order() {

    }

    public Order(Long id, Long merchantId, Long shopperId, double amount, Date createAt, Date completedAt) {
        this.id = id;
        this.merchantId = merchantId;
        this.shopperId = shopperId;
        this.amount = amount;
        this.createAt = createAt;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getShopperId() {
        return shopperId;
    }

    public void setShopperId(Long shopperId) {
        this.shopperId = shopperId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public String getWeek(){
        // TODO: If completedAt is not null return  year and week number in yyyyww pattern
        return "202207";
    }
}
