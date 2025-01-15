package com.example.store.model;



import com.example.order.model.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "store", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;


    @Column(name = "store_name", nullable = false, length = 100)
    private String storeName;


    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
