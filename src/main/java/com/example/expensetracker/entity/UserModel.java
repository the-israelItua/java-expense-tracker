package com.example.expensetracker.entity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {
    @NotBlank(message = "userName is required")
    @Size(min = 3, message = "userName should be at least three characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 5, message = "Password should be at least five characters")
    private String password;
}
