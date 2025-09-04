package com.clothes_shop.clothes_shop.domain;

import com.clothes_shop.clothes_shop.common.ERole;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "users")
@Entity
public class User extends BaseEntity{

    @Column(unique = true, nullable = true, length = 50)
    private String userName;

    @Column()
    private String password;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(name = "phone_number", length = 50, nullable = true)
    private String phoneNumber;

    @Column(name = "date_of_birth", nullable = true)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ERole role;

    public User(String email, String userName, String password, String address, String phoneNumber, LocalDate dateOfBirth, ERole role) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public ERole getRole() {
        return role;
    }
    public void setRole(ERole role) {
        this.role = role;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
