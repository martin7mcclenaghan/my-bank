package com.abc;

enum AccountNumberGenerator {

    INSTANCE;

    private int count = 1;

    synchronized int getNextAccountNumber () {
        return count++;
    }
}
