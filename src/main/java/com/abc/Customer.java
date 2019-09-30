package com.abc;

import java.util.ArrayList;
import java.util.List;

import com.abc.Account.AccountType;

import static java.lang.Math.abs;

class Customer {
    private String name;
    private List<Account> accounts;

    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }

    String getName() {
        return name;
    }

    boolean openAccount(AccountType accountType) {

        return accounts.add(new Account(accountType));

    }

    int getNumberOfAccounts() {
        return accounts.size();
    }

    double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    String statementForAccount(Account a) {
        String s = "";

        //Translate to pretty account type
        switch (a.getAccountType()) {
            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }


}
