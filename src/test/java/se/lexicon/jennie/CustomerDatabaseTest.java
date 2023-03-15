package se.lexicon.jennie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDatabaseTest {

    BankAccountDatabase bad = new BankAccountDatabase();
    CustomerDatabase cdb = new CustomerDatabase(bad);

    @Test
    void should_AddCustomer_When_CustomerNotFound() {

        Customer lisa = new Customer("Lisa", "Simpson", "lisa@email.com", 1);
        BankAccount ba = new BankAccount(1, 100, lisa);
        bad.addBankAccount(ba);
        boolean find = cdb.findCustomer(lisa);
        boolean add = cdb.addCustomer(lisa);
        assertFalse(find);
        assertTrue(add);
    }

    @Test
    void should_NotAddCustomer_When_CustomerFound() {

        Customer marge = new Customer("Marge", "Simpson", "marge@email.com", 2);
        BankAccount ba = new BankAccount(2, 200, marge);
        bad.addBankAccount(ba);
        cdb.addCustomer(marge);
        boolean find = cdb.findCustomer(marge);
        boolean add = cdb.addCustomer(marge);
        assertTrue(find);
        assertFalse(add);
    }

    @Test
    void should_ReturnTrue_When_CustomerFound() {

        Customer bart = new Customer("Bart", "Simpson", "bart@email.com", 3);
        BankAccount ba = new BankAccount(3, 300, bart);
        bad.addBankAccount(ba);
        cdb.addCustomer(bart);
        boolean find = cdb.findCustomer(bart);
        assertTrue(find);
    }

    @Test
    void should_ReturnFalse_When_CustomerNotFound() {

        Customer homer = new Customer("Homer", "Simpson", "homer@email.com", 4);
        BankAccount ba = new BankAccount(4, 400, homer);
        bad.addBankAccount(ba);
        boolean find = cdb.findCustomer(homer);
        assertFalse(find);
    }

    @Test
    void should_RemoveCustomer_When_CustomerFound() {

        Customer maggie = new Customer("Maggie", "Simpson", "maggie@email.com", 5);
        BankAccount ba = new BankAccount(5, 500, maggie);
        bad.addBankAccount(ba);
        cdb.addCustomer(maggie);
        boolean find = cdb.findCustomer(maggie);
        boolean remove = cdb.removeCustomer(maggie);
        assertTrue(find);
        assertTrue(remove);
    }

    @Test
    void should_NotRemoveCustomer_When_CustomerNotFound() {

        Customer maggie = new Customer("Maggie", "Simpson", "maggie@email.com", 5);
        BankAccount ba = new BankAccount(6, 600, maggie);
        bad.addBankAccount(ba);
        boolean find = cdb.findCustomer(maggie);
        boolean remove = cdb.removeCustomer(maggie);
        assertFalse(find);
        assertFalse(remove);
    }
}