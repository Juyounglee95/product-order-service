package com.example.productorderservice.payment.application.service;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
