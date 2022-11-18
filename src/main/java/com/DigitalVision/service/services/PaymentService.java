package com.DigitalVision.service.services;

import com.DigitalVision.service.models.Payment;
import com.DigitalVision.service.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment){

        return paymentRepository.save(payment);
    }

    public List<Payment> findAllPayments(){
        return paymentRepository.findAll();
    }
}

