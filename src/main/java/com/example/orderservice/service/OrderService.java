package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<Order> listOrdersForCustomer(String email) {
        return orderRepository.findByCustomerEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Order> listPendingOrdersForCustomer(String email) {
        return orderRepository.findByCustomerEmailAndStatus(email, "PENDING");
    }
}
