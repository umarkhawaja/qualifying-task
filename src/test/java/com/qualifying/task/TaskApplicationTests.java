package com.qualifying.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.qualifying.task.Controller.BalanceController;
import com.qualifying.task.Model.Balance;
import com.qualifying.task.Model.Transaction;
import com.qualifying.task.Service.TransactionService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskApplicationTests {

  @Mock
  TransactionService transactionService;

  @InjectMocks
  private BalanceController balanceController;

  List<Transaction> transactions = null;

  void setUp() {
    transactions = new ArrayList<>();
    Transaction transaction1 = new Transaction();
    transaction1.setAmount(new BigDecimal("100.00"));
    transaction1.setDate(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 15));
    transactions.add(transaction1);

    Transaction transaction2 = new Transaction();
    transaction2.setAmount(new BigDecimal("150.00"));
    transaction2.setDate(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 20));
    transactions.add(transaction2);

    Transaction transaction3 = new Transaction();
    transaction3.setAmount(new BigDecimal("250.00"));
    transaction3.setDate(LocalDate.of(2023, 5, 20));
    transactions.add(transaction3);
  }

  @Test
  public void testGetMonthlyBalance_WithValidYearAndMonth_ReturnsCorrectBalance() {
    setUp();
    when(transactionService.getTransactions()).thenReturn(transactions);
    Balance monthlyBalance = balanceController.getMonthlyBalance();

    assertEquals(new BigDecimal("250.00"), monthlyBalance.getAmount());
  }

  @Test
  public void testGetMonthlyBalance_NoTransactions_ReturnsZeroBalance() {
    when(transactionService.getTransactions()).thenReturn(Collections.emptyList());
    Balance monthlyBalance = balanceController.getMonthlyBalance();

    assertEquals(BigDecimal.ZERO, monthlyBalance.getAmount());
  }


  @Test
  public void testGetCumulativeBalance_WithTransactions_ReturnsCorrectBalance() {
    setUp();
    when(transactionService.getTransactions()).thenReturn(transactions);
    Balance cumulativeBalance = balanceController.getCumulativeBalance();

    assertEquals(new BigDecimal("500.00"), cumulativeBalance.getAmount());
  }

  @Test
  public void testGetCumulativeBalance_NoTransactions_ReturnsZeroBalance() {

    when(transactionService.getTransactions()).thenReturn(Collections.emptyList());
    Balance cumulativeBalance = balanceController.getCumulativeBalance();

    assertEquals(BigDecimal.ZERO, cumulativeBalance.getAmount());
  }

}
