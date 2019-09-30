package com.abc;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Customer martin = new Customer("Martin");
        bank.addCustomer(martin);
        martin.openAccount(Account.AccountType.SAVINGS);


    }


}
