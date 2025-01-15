package com.example.payment.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    private BigDecimal amount;

    @Column(name = "sale_id")
    private Long saleId;
}
