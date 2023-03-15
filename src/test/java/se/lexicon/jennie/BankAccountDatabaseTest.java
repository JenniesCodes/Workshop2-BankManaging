package se.lexicon.jennie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDatabaseTest {

    BankAccountDatabase bad = new BankAccountDatabase();

    @Test
    void should_AddBankAccount_When_AccountNotFound() {

        Customer marge = new Customer("Marge", "Simpson", "marge@email.com", 1);
        BankAccount m = new BankAccount(1, 100, marge);
        boolean find = bad.findByAccountNumber(m);
        boolean add = bad.addBankAccount(m);
        assertFalse(find);
        assertTrue(add);
    }

    @Test
    void should_NotAddBankAccount_When_AccountFound() {

        Customer homer = new Customer("Homer", "Simpson", "homer@email.com", 2);
        BankAccount h = new BankAccount(2, 200, homer);
        bad.addBankAccount(h);
        boolean find = bad.findByAccountNumber(h);
        boolean add = bad.addBankAccount(h);
        assertTrue(find);
        assertFalse(add);
    }

    @Test
    void should_ReturnTrue_When_ConnectedBankAccountsFound() {

        Customer ned = new Customer("Ned", "Flanders", "ned@email.com", 6);
        BankAccount n = new BankAccount(6, 600, ned);
        bad.addBankAccount(n);
        ArrayList<BankAccount> empty = new ArrayList<>();
        empty.add(n);
        ArrayList<BankAccount> find = bad.findConnectedBankAccounts(ned);
        assertEquals(empty, find);
    }

    @Test
    void should_ReturnEmptyArray_When_ConnectedBankAccountsNotFound() {

        Customer ned = new Customer("Ned", "Flanders", "ned@email.com", 6);
        BankAccount n = new BankAccount(6, 600, ned);
        ArrayList<BankAccount> empty = new ArrayList<>();
        ArrayList<BankAccount> find = bad.findConnectedBankAccounts(ned);
        assertEquals(empty, find);
    }

    @Test
    void should_ReturnTrue_When_BankAccountFound() {

        Customer lisa = new Customer("Lisa", "Simpson", "lisa@email.com", 3);
        BankAccount l = new BankAccount(3, 300, lisa);
        bad.addBankAccount(l);
        boolean find = bad.findByAccountNumber(l);
        assertTrue(find);
    }

    @Test
    void should_ReturnFalse_When_BankAccountNotFound() {

        Customer maggie = new Customer("Maggie", "Simpson", "maggie@email.com", 4);
        BankAccount m = new BankAccount(4, 400, maggie);
        boolean find = bad.findByAccountNumber(m);
        assertFalse(find);
    }

    @Test
    void should_RemoveBankAccount_When_AccountFound() {

        Customer bart = new Customer("Bart", "Simpson", "bart@email.com", 5);
        BankAccount b = new BankAccount(5, 500, bart);
        bad.addBankAccount(b);
        boolean find = bad.findByAccountNumber(b);
        boolean remove = bad.removeBankAccount(b);
        assertTrue(find);
        assertTrue(remove);
    }
}