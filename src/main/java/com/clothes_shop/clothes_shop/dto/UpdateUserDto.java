package com.clothes_shop.clothes_shop.dto;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateUserDto {

    @Nullable()
    @Size(min = 3, max = 50, message = "Username must be between 3-50 characters")
    private String userName;

    @Nullable()
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Nullable()
    @Email(message = "Invalid email format")
    private String email;

    @Nullable()
    private String address;

    @Nullable()
    private String phoneNumber;

    @Nullable()
    private LocalDate dateOfBirth;

    public UpdateUserDto(@Nullable String userName, @Nullable String password, @Nullable String email, @Nullable String address, @Nullable String phoneNumber, @Nullable LocalDate dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(@Nullable String userName) {
        this.userName = userName;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    public void setAddress(@Nullable String address) {
        this.address = address;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@Nullable LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
