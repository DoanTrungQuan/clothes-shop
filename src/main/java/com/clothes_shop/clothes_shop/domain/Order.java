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

    @Column(name = "origin_price")
    private double originPrice;

    @Column(name = "shipping_price")
    private double shippingPrice;

    @Column(name = "total_price")
    private double totalPrice;

    @Column()
    private double discount;

    @Column()
    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @Column()
    private String size;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
