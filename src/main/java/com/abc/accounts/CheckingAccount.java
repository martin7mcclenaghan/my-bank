package com.abc.accounts;

import com.abc.Transaction;

import java.util.List;

public class CheckingAccount extends Account {

    private final int accountNumber;
    private List<Transaction> transactions;

    CheckingAccount() {
        super();
        this.accountNumber = this.getAccountNumber();
    }

    @Override
    double interestEarned() {
        return 0;
    }

    @Override
    String getStatement() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Account Number: ").append(this.getAccountNumber()).append("\n");
        stringBuffer.append("Checking Account\n");

    }
}
