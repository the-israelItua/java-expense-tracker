package com.example.expensetracker.controllers;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("")
    public Page<Expense> getAllExpense(Pageable page) {
        return expenseService.getAllExpenses(page);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id) {
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("")
    public Expense addExpense(@RequestBody @Valid Expense expense){
        return expenseService.addExpense(expense);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        return expenseService.deleteExpense(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense){
        return expenseService.updateExpense(id, expense);
    }
}

