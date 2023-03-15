package se.lexicon.jennie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    Customer c = new Customer("Jennie", "Smith", "jennie@email.com", 1);

    BankAccount jennie = new BankAccount(1, 100000, c);

    @Test
    void bankNumberTest() {

        assertEquals(1, jennie.getAccountNumber());
    }

    @Test
    void balanceTest() {

        assertEquals(100000, jennie.getBalance());
    }

    @Test
    void customerTest() {

        assertEquals(c, jennie.getCustomer());
    }

    @Test
    void should_ReturnCorrectBalance_When_MoneyDeposited() {

        jennie.deposit(500);
        assertEquals(100500, jennie.getBalance());
    }

    @Test
    void should_NotDeposit_When_NegativeDeposit() {

        jennie.deposit(-200);
        assertEquals(100000, jennie.getBalance());
    }

    @Test
    void should_ReturnCorrectBalance_When_MoneyWithdrawn() {

        jennie.withdraw(500);
        assertEquals(99500, jennie.getBalance());
    }

    @Test
    void should_NotWithdraw_When_InsufficientFunds() {

        jennie.withdraw(200000);
        assertEquals(100000, jennie.getBalance());
    }
}