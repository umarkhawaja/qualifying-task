package com.qualifying.task.Controller;

import com.qualifying.task.Model.Balance;
import com.qualifying.task.Model.BalanceType;
import com.qualifying.task.Model.Transaction;
import com.qualifying.task.Service.TransactionService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balances")
public class BalanceController {

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/monthly")
  public Balance getMonthlyBalance() {
    try {
      List<Transaction> transactions = transactionService.getTransactions();
      BigDecimal monthlyBalance = BigDecimal.ZERO;
      for (Transaction transaction : transactions) {
        if (transaction.getDate().getYear() == LocalDate.now().getYear()
            && transaction.getDate().getMonthValue() == LocalDate.now().getMonthValue()) {
          monthlyBalance = monthlyBalance.add(transaction.getAmount());
        }
      }

      return new Balance(BalanceType.MONTHLY, monthlyBalance);
    } catch (Exception e) {
      throw new RuntimeException("Unable to calculate the monthly balance");
    }
  }

  @GetMapping("/cumulative")
  public Balance getCumulativeBalance() {
    try{
      List<Transaction> transactions = transactionService.getTransactions();

      BigDecimal cumulativeBalance = BigDecimal.ZERO;
      for (Transaction transaction : transactions) {
        cumulativeBalance = cumulativeBalance.add(transaction.getAmount());
      }

      return new Balance(BalanceType.CUMULATIVE, cumulativeBalance);
    }
    catch (Exception e) {
      throw new RuntimeException("Unable to calculate the cumulative balance");
    }
  }
}
