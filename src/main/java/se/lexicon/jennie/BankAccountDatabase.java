package se.lexicon.jennie;

import java.util.ArrayList;

public class BankAccountDatabase {

    private ArrayList<BankAccount> bankAccounts;

    public BankAccountDatabase() {
        bankAccounts = new ArrayList<>();
    }

    public boolean addBankAccount(BankAccount accountToAdd) {

        if(!findByAccountNumber(accountToAdd)) {
            bankAccounts.add(accountToAdd);
            return true;
        }
        return false;
    }

    public ArrayList<BankAccount> findConnectedBankAccounts(Customer customer) {

        ArrayList<BankAccount> customersBankAccounts = new ArrayList<>();

        for(BankAccount cba : bankAccounts) {
            if(cba.getCustomer() == customer) {
                customersBankAccounts.add(cba);
            }
        }
        return customersBankAccounts;
    }
    public boolean findByAccountNumber(BankAccount accountToFind) {

        for(BankAccount ba : bankAccounts) {
            if(ba.getAccountNumber() == accountToFind.getAccountNumber()) {
                return true;
            }
        }
        return false;
    }

    public boolean removeBankAccount(BankAccount accountToRemove) {

        if(findByAccountNumber(accountToRemove)) {
            bankAccounts.remove(accountToRemove);
            return true;
        }
        return false;
    }
}
