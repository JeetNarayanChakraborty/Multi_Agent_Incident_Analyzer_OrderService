package com.example.orderservice.dto;

import java.math.BigDecimal;

public class OrderRequest {
    private String customerEmail;
    private BigDecimal totalAmount;

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
}
