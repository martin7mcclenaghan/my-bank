package com.abc;

import com.abc.Account.AccountType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

class Customer {
    private String name;
    private List<Account> accountList;

    Customer(String name) {
        this.name = name;
        this.accountList = new ArrayList<Account>();
    }

    private String toDollars (double amount){
        return String.format("$%,.2f", abs(amount));
    }

    String getName() {
        return name;
    }

    boolean openAccount(AccountType accountType) {
        return accountList.add(new Account(accountType));

    }

    int getNumberOfAccounts() {
        return accountList.size();
    }

    double totalInterestEarned() {
        double total = 0;
        for (Account a : accountList)
            total += a.interestEarned();
        return total;
    }

    String getStatement() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Statement for ").append(name).append("\n");
        double total = 0.0;

        for (Account account : accountList) {
            stringBuffer.append("\n").append(statementForAccount(account)).append("\n");
            total += account.sumTransactions();
        }

        stringBuffer.append("\nTotal In All Accounts ").append(toDollars(total));
        return stringBuffer.toString();
    }

   private String statementForAccount(Account account) {

        StringBuffer stringBuffer = new StringBuffer();

        //Translate to pretty account type
       if(account.getAccountType() == AccountType.CHECKING){
           stringBuffer.append("Checking Account\n");

       } else if(account.getAccountType() == AccountType.SAVINGS){
           stringBuffer.append("Savings Account\n");

       } else if(account.getAccountType() == AccountType.MAXI_SAVINGS){
           stringBuffer.append("Maxi Savings Account\n");
       }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction transaction : account.transactions) {

            stringBuffer.append(transaction.getTransactionType()).append(" ");
            stringBuffer.append(transaction.getAmountString()).append("\n");
            total += transaction.getAmount();
        }
        stringBuffer.append("Total ").append(toDollars(total));

        return stringBuffer.toString();
    }


}
