package com.qualifying.task.Service;

import com.qualifying.task.Model.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  private ExternalApiService externalApiService;

  public List<Transaction> getTransactions() {
    return externalApiService.getTransactions();
  }

}
