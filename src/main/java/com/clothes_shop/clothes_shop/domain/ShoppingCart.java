package com.clothes_shop.clothes_shop.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity{

    @OneToMany(mappedBy = "cart")
    private List<Order>  orders = new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
