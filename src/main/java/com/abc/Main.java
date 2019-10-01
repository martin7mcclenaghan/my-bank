package com.abc;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Customer martin = new Customer("Martin");
        bank.addCustomer(martin);
        martin.openAccount(Account.AccountType.SAVINGS);
        System.out.println(martin.getNumberOfAccounts());
        System.out.println(martin.getStatement());

        Customer adam = new Customer("Adam");
        bank.addCustomer(adam);
        adam.openAccount(Account.AccountType.CHECKING);
        System.out.println(adam.getNumberOfAccounts());
        System.out.println(adam.getStatement());


    }


}
