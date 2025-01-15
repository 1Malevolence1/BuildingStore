package com.example.supplier.model;



import com.example.order.model.Order;
import com.example.product.model.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "supplier", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;


    @Column(name = "supply_date")
    private LocalDate supplyDate;

    private Long quantity;

    @Column(name = "product_id")
    private Long productId;
    @Column(name = "order_id")
    private Long orderId;
}
