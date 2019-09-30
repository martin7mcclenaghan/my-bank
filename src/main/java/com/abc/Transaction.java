package com.abc;

import java.util.Date;

import static java.lang.Math.abs;

class Transaction {

    enum TransactionType {WITHDRAWAL, DEPOSIT};

    private TransactionType transactionType;
    private final double amount;
    private Date transactionDate;

    Transaction(double amount) {
        this.amount = amount;

        if(amount > 0){
            this.transactionType = TransactionType.DEPOSIT;
        } else {
            this.transactionType = TransactionType.WITHDRAWAL;
        }

        this.transactionDate = DateProvider.getInstance().now();
    }

    String getTransactionType() {
        return this.transactionType.name();
    }

    String getAmountString() {
        return String.format("$%,.2f", abs(this.amount));
    }

    double getAmount (){
        return this.amount;
    }

    String getTransactionDate() {
        return this.transactionDate.toString();
    }
}
