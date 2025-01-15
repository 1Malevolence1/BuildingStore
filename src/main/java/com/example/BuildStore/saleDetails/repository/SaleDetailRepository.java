package com.example.saleDetails.repository;

import com.example.saleDetails.model.SaleDetail;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

    @Query(value = "select pt.type_name, SUM(sd.quantity * sd.price) as  totalRevenue from sale_detail sd join  product p on sd.product_id = p.product_id join product_type pt on p.product_type_id = pt.product_type_id " +
            "group by  pt.product_type_id order by  totalRevenue DESC", nativeQuery = true)
    List<Tuple> reportReportSalesByProductType();
}
