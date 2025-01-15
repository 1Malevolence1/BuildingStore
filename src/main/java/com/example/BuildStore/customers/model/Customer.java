package com.example.customers.model;




import com.example.sale.model.Sale;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone")
    private String phone;


    @Column(name = "email")
    private String email;


    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> sales;
}
