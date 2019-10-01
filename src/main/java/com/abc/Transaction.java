package com.abc;

import java.util.Date;

import static java.lang.Math.abs;

public class Transaction {

    enum TransactionType {WITHDRAWAL, DEPOSIT};

    private final TransactionType transactionType;
    private final double amount;
    private final Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;

        if(amount > 0){
            this.transactionType = TransactionType.DEPOSIT;
        } else {
            this.transactionType = TransactionType.WITHDRAWAL;
        }

        this.transactionDate = DateProvider.getInstance().now();
    }

   public String getTransactionType() {
        return this.transactionType.name();
    }

   public String getAmountString() {
        return String.format("$%,.2f", abs(this.amount));
    }

    public double getAmount (){
        return this.amount;
    }

   public String getTransactionDate() {
        return this.transactionDate.toString();
    }
}
