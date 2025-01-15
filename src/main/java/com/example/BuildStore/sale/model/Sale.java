package com.example.sale.model;



import com.example.customers.model.Customer;
import com.example.saleDetails.model.SaleDetail;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sale", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;

}
