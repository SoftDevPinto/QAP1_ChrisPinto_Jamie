package com.keyin.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testTransfer() {
        Account accountToDebit = new Account(1,"accountToDebit", 200.00);
        Account accountToCredit = new Account(2,"accountToCredit", 0.00);

        accountToDebit.transfer(accountToCredit, 100.00);

        Assertions.assertTrue(accountToCredit.getBalance() == 100.00);

        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
    }

    @Test
    public void testTransferLowBalance() {
        Account accountToDebit = new Account(1,"accountToDebit", 50.00);
        Account accountToCredit = new Account(2,"accountToCredit", 0.00);

        accountToDebit.transfer(accountToCredit, 100.00);

        Assertions.assertFalse(accountToCredit.getBalance() == 100.00);

        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
    }

    @Test
    public void testTransferAsInQAP() {
        // Create two Account objects with specific ids, names, and starting balances
        Account accountToDebit = new Account(1, "accountToDebit", 5000.00);
        Account accountToCredit = new Account(2, "accountToCredit", 4000.00);

        // Call the transfer method on the accountToDebit object, transferring 1000.00 to the accountToCredit object
        accountToDebit.transfer(accountToCredit, 1000.00);

        // Use the assertTrue method from the Assertions class to check if the balance of accountToCredit after the transfer is equal to 5000.00
        Assertions.assertTrue(accountToCredit.getBalance() == 5000.00);

        // Print out the balances of both accounts for informational purposes
        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
    }


    @Test
    public void testDebit() {
        // Create a new Account object with an id of 1, a name of "testDebit", and a starting balance of 200.00
        Account account = new Account(1, "testDebit", 200.00);

        // Call the debit method on the account object with a debit amount of 100.00
        account.debit(100.00);

        // Use the assertTrue method from the Assertions class to check if the balance after the debit is equal to 100.00
        Assertions.assertTrue(account.getBalance() == 100.00);

        // Print out the balance after the debit for informational purposes
        System.out.println("Account balance after debit: " + account.getBalance());
    }


    @Test
    public void testDebitOverdrawn() {
        // Create a new Account object with an id of 1, a name of "testDebitOverdrawn", and a starting balance of 200.00
        Account account = new Account(1, "testDebitOverdrawn", 200.00);

        // Call the debit method on the account object with a debit amount of 300.00
        account.debit(300.00);

        // Use the assertTrue method from the Assertions class to check if the balance after the attempted debit is equal to 200.00
        Assertions.assertTrue(account.getBalance() == 200.00);

        // Print out the balance after the attempted overdraft for informational purposes
        System.out.println("Account balance after debit with overdrawn: " + account.getBalance());
    }


    @Test
    public void testCredit() {
        // Create a new Account object with an id of 1, a name of "testCredit", and a starting balance of 200.00
        Account account = new Account(1, "testCredit", 200.00);

        // Call the credit method on the account object with a credit amount of 100.00
        account.credit(100.00);

        // Use the assertTrue method from the Assertions class to check if the balance after the credit is equal to 300.00
        Assertions.assertTrue(account.getBalance() == 300.00);

        // Print out the balance after the credit for informational purposes
        System.out.println("Account balance after credit: " + account.getBalance());
        System.out.println("Test credit");
    }

    // This method tests the transfer method with a negative amount. It creates two accounts and attempts to transfer a negative amount.
    // It asserts that the balance of the recipient account does not change and prints the balances of both accounts.
    @Test
    public void testTransferNegativeAmount() {
        // Create two Account objects with initial balances
        Account accountToDebit = new Account(1, "accountToDebit", 5000.00);
        Account accountToCredit = new Account(2, "accountToCredit", 4000.00);

        // Call transfer method with negative amount
        accountToDebit.transfer(accountToCredit, -1000.00);

        // Assert that the recipient account's balance remains unchanged
        Assertions.assertFalse(accountToCredit.getBalance() == 4000.00);

        // Print the final balances of both accounts
        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
        System.out.println("Transfer negative amount");
    }

    @Test
    public void testTransferZeroAmount() {
        // Create two Account objects with initial balances
        Account accountToDebit = new Account(1, "accountToDebit", 5000.00);
        Account accountToCredit = new Account(2, "accountToCredit", 4000.00);

        // Call transfer method with zero amount
        accountToDebit.transfer(accountToCredit, 0.00);

        // Assert that the recipient account's balance remains unchanged
        Assertions.assertTrue(accountToCredit.getBalance() == 4000.00);

        // Print the final balances of both accounts
        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
        System.out.println("Transfer zero amount");
    }

    @Test
    public void testTransferSameAccount() {
        // Create two Account objects with initial balances
        Account accountToDebit = new Account(1, "accountToDebit", 5000.00);
        Account accountToCredit = new Account(2, "accountToCredit", 4000.00);

        // Call transfer method with zero amount
        accountToDebit.transfer(accountToDebit, 1000.00);

        // Assert that the recipient account's balance remains unchanged
        Assertions.assertTrue(accountToDebit.getBalance() == 5000.00);

        // Print the final balances of both accounts
        System.out.println("Account 1 balance: " + accountToDebit.getBalance());
        System.out.println("Account 2 balance: " + accountToCredit.getBalance());
        System.out.println("Transfer to same account");
    }


}