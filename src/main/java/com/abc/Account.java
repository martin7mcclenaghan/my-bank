package com.abc;

import java.util.ArrayList;
import java.util.List;

abstract class Account {

    // == fields ==

    private final AccountType accountType;
    private final int accountNumber;
    List<Transaction> transactions;


    // == constructor ==

    Account(AccountType accountType) {
        this.accountType = accountType;
        this.accountNumber = AccountNumberGenerator.INSTANCE.getNextAccountNumber();
        this.transactions = new ArrayList<Transaction>();
    }

    // == public methods ==

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    double interestEarned() {
        double amount = sumTransactions();
        switch (accountType) {
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount - 1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
                if (amount <= 1000)
                    return amount * 0.02;
                if (amount <= 2000)
                    return 20 + (amount - 1000) * 0.05;
                return 70 + (amount - 2000) * 0.1;
            default:
                return amount * 0.001;
        }
    }

    double sumTransactions() {
        return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t : transactions)
            amount += t.getAmount();
        return amount;
    }

    AccountType getAccountType() {
        return accountType;
    }

    int getAccountNumber() {
        return accountNumber;
    }
}
