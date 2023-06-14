package com.qualifying.task.Service;

import com.qualifying.task.Model.Transaction;
import com.qualifying.task.Repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExternalApiService {

  @Autowired
  private TransactionRepository transactionRepository;

  public List<Transaction> getTransactions(){
    return transactionRepository.findAll();
  }
}
