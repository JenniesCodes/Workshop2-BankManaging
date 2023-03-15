package se.lexicon.jennie;

import java.util.ArrayList;

public class CustomerDatabase {

    private ArrayList<Customer> customers;
    private BankAccountDatabase bad;

    public CustomerDatabase(BankAccountDatabase bad) {

        customers = new ArrayList<>();
        this.bad = bad;
    }

    public boolean addCustomer(Customer customerToAdd) {

        if(!findCustomer(customerToAdd) && (bad.findConnectedBankAccounts(customerToAdd).size() > 0)) {
            customers.add(customerToAdd);
            return true;
        } else {
            return false;
        }
    }

    public boolean findCustomer(Customer customerToFind) {

        for(Customer c : customers) {
            if(c.getEmail().equals(customerToFind.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean removeCustomer(Customer customerToRemove) {

        if(findCustomer(customerToRemove)) {
            customers.remove(customerToRemove);
            return true;
        } else {
            return false;
        }
    }
}
