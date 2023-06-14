package com.qualifying.task.Model;

import java.math.BigDecimal;

public class Balance {

  private BalanceType balanceType;
  private BigDecimal amount;

  public Balance() {
  }

  public Balance(BalanceType balanceType, BigDecimal amount) {
    this.balanceType = balanceType;
    this.amount = amount;
  }

  public BalanceType getBalanceType() {
    return balanceType;
  }

  public void setBalanceType(BalanceType balanceType) {
    this.balanceType = balanceType;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
