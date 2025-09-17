package com.clothes_shop.clothes_shop.domain;

import com.clothes_shop.clothes_shop.common.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{
    @Column()
    private int quantity;

    @Column()
    private double price;

    @Column()
    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
