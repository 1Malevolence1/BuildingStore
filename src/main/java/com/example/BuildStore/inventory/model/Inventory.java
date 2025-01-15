package com.example.inventory.model;


import com.example.product.model.Product;
import com.example.store.model.Store;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventory", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;


    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "date")
    private LocalDate date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
