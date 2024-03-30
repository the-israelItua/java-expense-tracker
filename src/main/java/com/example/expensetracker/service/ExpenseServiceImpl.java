package com.example.expensetracker.service;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.exceptions.NotFoundException;
import com.example.expensetracker.repositories.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new NotFoundException("Expense not found"));
    }

    @Override
    public Expense addExpense(Expense expense){
       return expenseRepository.save(expense);
    }

    @Override
    public String deleteExpense(Long id) {
        Expense expense = getExpenseById(id);
         expenseRepository.delete(expense);
        return "Expense deleted successfully";
    }

    @Override
    public Expense updateExpense(Long id, Expense expense){
        Expense existing = getExpenseById(id);
        existing.setName(expense.getName() == null ? existing.getName() : expense.getName());
        existing.setCategory(expense.getCategory() == null ? existing.getCategory() : expense.getCategory());
        existing.setAmount(expense.getAmount() == null ? existing.getAmount() : expense.getAmount());
        existing.setDescription(expense.getDescription() == null ? existing.getDescription() : expense.getDescription());
        existing.setDate(expense.getDate() == null ? existing.getDate() : expense.getDate());

        return expenseRepository.save(existing);
    }
}
