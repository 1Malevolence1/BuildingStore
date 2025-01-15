package com.example.sale.repository;

import com.example.sale.model.Sale;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT c.full_name AS customer, COUNT(s.sale_id) AS numberOfSales, SUM(s.total_amount) AS totalSpent " +
            "FROM customer c JOIN sale s ON c.customer_id = s.customer_id " +
            "GROUP BY c.customer_id ORDER BY totalSpent DESC", nativeQuery = true)
    List<Tuple> reportSalesByCustomers();



    @Query(value = "select p.product_name, sum(sd.quantity) as totalQuantitySold, sum(sd.quantity * sd.price)  as TotalRevenue from  sale_detail  sd join  product p on sd.product_id = p.product_id group by  " +
            "p.product_id order by TotalRevenue desc", nativeQuery = true )
    List<Tuple> reportSalesByProducts();
}

