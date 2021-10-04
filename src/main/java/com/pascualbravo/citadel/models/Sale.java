package com.pascualbravo.citadel.models;

import java.time.LocalDateTime;

public class Sale {
    private int saleId;
    private LocalDateTime specifyAt;
    private double totalPrice;

    /**
     * @return the saleId
     */
    public int getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    /**
     * @return the specifyAt
     */
    public LocalDateTime getSpecifyAt() {
        return specifyAt;
    }

    /**
     * @param specifyAt the specifyAt to set
     */
    public void setSpecifyAt(LocalDateTime specifyAt) {
        this.specifyAt = specifyAt;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
