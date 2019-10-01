package com.abc;

import java.util.ArrayList;
import java.util.List;

class Bank {

    // == fields ==

    private List<Customer> customers;

    // == constructor ==

    Bank() {
        customers = new ArrayList<Customer>();
    }

    // == private methods ==

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {

        StringBuffer stringBuffer = new StringBuffer();
        if(number == 1){
            stringBuffer.append(word);
        } else{
            stringBuffer.append(word).append("s");
        }

        return stringBuffer.toString();
    }

    // == package-private methods ==

    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    String customerSummary() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Customer Summary");

        for (Customer c : customers) {
            stringBuffer.append("\n").append(c.getName()).append(" (").append(c.getNumberOfAccounts())
                    .append(format(c.getNumberOfAccounts(), " account")).append(")");

        }

        return stringBuffer.toString();
    }

    double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
