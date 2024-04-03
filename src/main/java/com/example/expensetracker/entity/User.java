package com.example.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "userName is required")
    @Size(min = 3, message = "userName should be at least three characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false )
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}


