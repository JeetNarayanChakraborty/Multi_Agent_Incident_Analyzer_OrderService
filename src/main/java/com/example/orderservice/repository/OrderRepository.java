package com.example.orderservice.repository;

import com.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerEmail(String customerEmail);

    List<Order> findByStatus(String status);

    // Regression: composite query on (customer_email, status).
    // No composite index exists on the orders table -> sequential scan under load.
    @Query("SELECT o FROM Order o WHERE o.customerEmail = :email AND o.status = :status")
    List<Order> findByCustomerEmailAndStatus(
        @Param("email") String email,
        @Param("status") String status
    );
}
