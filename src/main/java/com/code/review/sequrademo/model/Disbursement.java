package com.code.review.sequrademo.model;

public class Disbursement {

    private Long id;
    private Long order_id;
    private Long merchant_id;
    private String week;
    private double disburAmount;
    private double percentage;
    private String state;

    public Disbursement(Long order_id, Long merchant_id, String week, double disburAmount, double percentage, String state) {
        this.order_id = order_id;
        this.merchant_id = merchant_id;
        this.week = week;
        this.disburAmount = disburAmount;
        this.percentage = percentage;
        this.state = state;
    }

    public Disbursement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(Long merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public double getDisburAmount() {
        return disburAmount;
    }

    public void setDisburAmount(double disburAmount) {
        this.disburAmount = disburAmount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
