package com.abc.accounts;

public class SavingsAccount extends Account {

    SavingsAccount() {
        super();
    }

    @Override
    double interestEarned() {
        return 0;
    }
}
