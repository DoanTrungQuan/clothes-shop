package com.clothes_shop.clothes_shop.domain;

import com.clothes_shop.clothes_shop.common.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends BaseEntity{

    @Column(nullable = true, length = 50)
    @Size(min = 3, max = 50, message = "Username must be between 3-50 characters")
    private String userName;

    @Column()
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Column(unique = true, nullable = true)
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(name = "phone_number", length = 50, nullable = true)
    private String phoneNumber;

    @Column(name = "date_of_birth", nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order>  orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShoppingCart cart;
}
