package com.abc;

import com.abc.accounts.Account;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

class Customer {

    // == fields ==

    private String name;
    private List<Account> accountList;

    // == constructor ==

    Customer(String name) {
        this.name = name;
        this.accountList = new ArrayList<Account>();
    }

    // == private methods ==

    private String toDollars (double amount){
        return String.format("$%,.2f", abs(amount));
    }

    // == package-private methods ==

    String getName() {
        return name;
    }

    void openAccount(Account account) {
        accountList.add(account);

    }

    int getNumberOfAccounts() {
        return accountList.size();
    }

    Account getAccount (int accountNumber){

        for(Account account : accountList){
            if(accountNumber ==  account.getAccountNumber()){
                return account;
            }
        }

        return null;
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
            stringBuffer.append("\n").append(account.getStatement()).append("\n");
            total += account.sumTransactions();
        }

        stringBuffer.append("\nTotal In All Accounts ").append(toDollars(total));
        return stringBuffer.toString();
    }




}
