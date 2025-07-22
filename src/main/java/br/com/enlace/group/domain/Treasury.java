package br.com.enlace.group.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Treasury {

    private BigDecimal currentBalance;
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private LocalDateTime lastUpdated;
    //private List<Transaction> recentTransactions;
    private BigDecimal monthlyGoal;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
