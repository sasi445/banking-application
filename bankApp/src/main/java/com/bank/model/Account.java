package com.bank.model;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAccountBalance(String accountNumber) {
        if (this.accountNumber.equals(accountNumber)) {
            return this.balance;
        }
        return null;
    }
}
