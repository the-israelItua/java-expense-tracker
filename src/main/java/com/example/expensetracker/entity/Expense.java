package com.example.expensetracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Expense name is required")
    @Size(min = 3, message = "Expense name should be atleast three characters")
    private String name;

    private String description;

    @NotNull(message = "Expense amount is required")
    private BigDecimal amount;

    @NotBlank(message = "Expense category is required")
    private String category;

    @NotNull(message = "Expense date is required")
    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false )
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}
