package com.example.product.model;


import com.example.inventory.model.Inventory;
import com.example.orderDetails.model.OrderDetails;
import com.example.saleDetails.model.SaleDetail;
import com.example.supplier.model.Supplier;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;


    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock")
    private Long stock;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Inventory> inventories;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;


}
