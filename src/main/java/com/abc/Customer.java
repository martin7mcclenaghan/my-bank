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

    boolean openAccount(AccountType accountType) {
        return accountList.add(new Account(accountType));

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
            stringBuffer.append("\n").append(statementForAccount(account)).append("\n");
            total += account.sumTransactions();
        }

        stringBuffer.append("\nTotal In All Accounts ").append(toDollars(total));
        return stringBuffer.toString();
    }

   private String statementForAccount(Account account) {

        StringBuffer stringBuffer = new StringBuffer();

        //Show account number generated by Singleton class
        stringBuffer.append("Account Number: ").append(account.getAccountNumber()).append("\n");

        //Show account type
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
