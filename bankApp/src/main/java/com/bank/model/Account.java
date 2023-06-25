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
    public void deposit(BigDecimal depositAmount) {
        BigDecimal currentBalance = this.getBalance();
        BigDecimal newBalance = currentBalance.add(depositAmount);
        this.setBalance(newBalance);
        System.out.println("Deposit successful. Current balance: " + newBalance);

    }
    public void withdraw(BigDecimal withdrawalAmount) {
        BigDecimal currentBalance = this.getBalance();
        if (withdrawalAmount.compareTo(currentBalance) <= 0) {
            BigDecimal newBalance = currentBalance.subtract(withdrawalAmount);
            this.setBalance(newBalance);
            System.out.println("Withdrawal successful. Current balance: " + newBalance);
        } else {
            System.out.println("Insufficient funds. Cannot complete withdrawal.");
        }
    }
}
