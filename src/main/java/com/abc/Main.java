package com.abc;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Customer martin = new Customer("Martin");
        bank.addCustomer(martin);
        martin.openAccount(AccountType.CHECKING);
        martin.getAccount(1).deposit(500);
        martin.openAccount(AccountType.SAVINGS);
        martin.getAccount(2).deposit(100);
        System.out.println(martin.getNumberOfAccounts());
        System.out.println(martin.getStatement());

        Customer adam = new Customer("Adam");
        bank.addCustomer(adam);
        adam.openAccount(AccountType.CHECKING);
        adam.getAccount(3).deposit(500);
        System.out.println(adam.getStatement());

        System.out.println(bank.customerSummary());


    }


}
