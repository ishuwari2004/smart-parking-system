package parking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import parking_system.model.Payment;
import parking_system.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    // Add Payment
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {

        double total = payment.getHours() * payment.getRatePerHour();

        payment.setTotalAmount(total);

        return paymentRepository.save(payment);
    }

    // Get All Payments
    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }
}