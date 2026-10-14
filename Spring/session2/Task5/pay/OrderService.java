package com.example.pay;

public class OrderService {

    private PaymentGateway paymentGateway;

    // Setter injection
    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void placeOrder() {
        System.out.println("Order placed successfully.");
        paymentGateway.processPayment();
    }
}
