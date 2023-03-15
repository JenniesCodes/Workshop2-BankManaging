package se.lexicon.jennie;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private Customer customer;

    public BankAccount(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(double deposit) {

        if(deposit > 0) {
            balance += deposit;
        }
    }

    public void withdraw(double withdraw) {

        if(withdraw > 0 && withdraw <= balance) {
            balance -= withdraw;
        }
    }
}
