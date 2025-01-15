package com.example.inventory.repository;

import com.example.inventory.model.Inventory;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {




    @Query(value = "SELECT st.store_name AS storeName, p.product_name AS productName, i.quantity AS stockQuantity " +
            "FROM inventory i JOIN store st ON i.store_id = st.store_id " +
            "JOIN product p ON i.product_id = p.product_id " +
            "ORDER BY st.store_name, p.product_name", nativeQuery = true)
    List<Tuple> reportReportByPointOfStore();
}
