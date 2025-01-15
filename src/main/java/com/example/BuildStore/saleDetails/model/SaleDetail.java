package com.example.saleDetails.model;


import com.example.product.model.Product;
import com.example.sale.model.Sale;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sale_detail", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class SaleDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private Long id;

    private Long quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "saleId", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
}
