package com.example.productorderservice.payment.application.adapter;


import com.example.productorderservice.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
