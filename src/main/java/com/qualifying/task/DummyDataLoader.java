package com.qualifying.task;

import com.qualifying.task.Model.Transaction;
import com.qualifying.task.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DummyDataLoader implements CommandLineRunner {

  private final TransactionRepository transactionRepository;

  @Autowired
  public DummyDataLoader(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public void run(String... args) {
    Transaction transaction1 = new Transaction();
    transaction1.setAmount(new BigDecimal("100.00"));
    transaction1.setDate(LocalDate.of(2023, 6, 15));
    transactionRepository.save(transaction1);

    Transaction transaction2 = new Transaction();
    transaction2.setAmount(new BigDecimal("150.00"));
    transaction2.setDate(LocalDate.of(2023, 6, 20));
    transactionRepository.save(transaction2);

    Transaction transaction3 = new Transaction();
    transaction3.setAmount(new BigDecimal("250.00"));
    transaction3.setDate(LocalDate.of(2023, 5, 20));
    transactionRepository.save(transaction3);

  }
}
