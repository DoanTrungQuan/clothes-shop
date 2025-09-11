package com.clothes_shop.clothes_shop.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

}
