package com.example.payment.repostiory;

import com.example.payment.model.Payment;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT st.store_name AS storeName, o.status AS orderStatus, SUM(p.amount) AS totalAmount " +
            "FROM payment p " +
            "JOIN sale sal ON p.sale_id = sal.sale_id " +
            "JOIN sale_detail sd ON sal.sale_id = sd.sale_id " +
            "JOIN product prod ON sd.product_id = prod.product_id " +
            "JOIN order_detail od ON prod.product_id = od.product_id " +
            "JOIN orders o ON od.order_id = o.order_id " +
            "JOIN store st ON o.store_id = st.store_id " +
            "GROUP BY st.store_name, o.status " +
            "ORDER BY st.store_name", nativeQuery = true)
    List<Tuple> reportPaymentAndOrderStatus();
}
