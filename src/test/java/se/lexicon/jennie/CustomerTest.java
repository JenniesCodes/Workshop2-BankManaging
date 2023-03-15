package se.lexicon.jennie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Customer jennie = new Customer("Jennie", "Smith", "jennie@email.com", 1);

    @Test
    void firstNameTest() {

        assertEquals("Jennie", jennie.getFirstName());

        /*
        Test-method broken into steps:

        (given: the expected value)
        String firstNameTest = "Jennie";

        (when: invoke method and store value)
        String firstName = jennie.getFirstName();

        (then: assertion / check against expected result)
        assertEquals(firstNameTest, firstName);
         */
    }

    @Test
    void lastNameTest() {

        assertEquals("Smith", jennie.getLastName());
    }

    @Test
    void emailTest() {
        assertEquals("jennie@email.com", jennie.getEmail());
    }

    @Test
    void idTest() {
        assertEquals(1, jennie.getId());
    }
}