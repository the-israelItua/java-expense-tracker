package com.example.expensetracker.service;

import com.example.expensetracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {

   Page<Expense> getAllExpenses(Pageable page);

   Expense getExpenseById(Long id);

   Expense addExpense(Expense expense);
   String deleteExpense(Long id);

   Expense updateExpense(Long id, Expense expense);
}
