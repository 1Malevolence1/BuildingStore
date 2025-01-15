package com.example.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "product_type", schema = "public")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductType{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long id;


    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "typeName = " + typeName + ", " +
                "description = " + description + ")";
    }
}