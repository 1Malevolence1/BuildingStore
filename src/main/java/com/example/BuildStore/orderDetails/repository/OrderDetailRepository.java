package com.example.orderDetails.repository;

import com.example.orderDetails.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {
}
