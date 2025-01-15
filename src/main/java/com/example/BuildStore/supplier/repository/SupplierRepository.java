package com.example.supplier.repository;

import com.example.supplier.model.Supplier;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT p.product_name AS productName, SUM(s.quantity) AS totalSupplied, MAX(s.supply_date) AS lastSupplyDate " +
            "FROM supplier s JOIN product p ON s.product_id = p.product_id " +
            "GROUP BY p.product_id ORDER BY totalSupplied DESC", nativeQuery = true)
    List<Tuple> reportReportSupplyCostsByGoodsResponseDto();
}
