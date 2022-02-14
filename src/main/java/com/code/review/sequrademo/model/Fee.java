package com.code.review.sequrademo.model;

public class Fee {
    private int id;
    private double amountBase;
    private double amountLimit;
    private double percentage;

    public Fee(int id, double amountBase, double amountLimit, double percentage) {
        this.id = id;
        this.amountBase = amountBase;
        this.amountLimit = amountLimit;
        this.percentage = percentage;
    }

    public Fee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmountBase() {
        return amountBase;
    }

    public void setAmountBase(double amountBase) {
        this.amountBase = amountBase;
    }

    public double getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(double amountLimit) {
        this.amountLimit = amountLimit;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
