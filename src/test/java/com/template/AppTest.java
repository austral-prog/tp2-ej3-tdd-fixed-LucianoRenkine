package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.deposit;
import static com.template.App.extract;
import static com.template.App.transfer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void testNegativeDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    void testNonExistentDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "tomi", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    void testExtract() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }
    @Test
    void testNegativeExtract() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    void testNonExistentBalance() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",0);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", 5);
        assertEquals(0, updatedAccounts.get("mati"));
    }
    @Test
    void testNonExistentExtract() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccounts = extract(accounts, "tomi", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }
    @Test
    void testTransfer() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "mati", "juan", 5);
        assertEquals(25, updatedAccount1.get("juan"));
        assertEquals(5, updatedAccount1.get("mati"));
    }
    @Test
    void testNonExistentBothBalances() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",0);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "mati", "juan", 5);
        assertEquals(0, updatedAccount1.get("mati"));
        assertEquals(20, updatedAccount1.get("juan"));
    }
    @Test
    void testNonExistentTransfer1() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "tomi", "mati", 5);
        assertEquals(10, updatedAccount1.get("mati"));
        assertEquals(20, updatedAccount1.get("juan"));
    }
    @Test
    void testNonExistentTransfer2() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "mati", "tomi", 5);
        assertEquals(10, updatedAccount1.get("mati"));
        assertEquals(20, updatedAccount1.get("juan"));
    }
    @Test
    void testNegativeTransfer() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "mati", "juan", -5);
        assertEquals(10, updatedAccount1.get("mati"));
        assertEquals(20, updatedAccount1.get("juan"));
    }
    @Test
    void testSelfTransfer() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati",10);
        accounts.put("juan",20);
        Map<String, Integer> updatedAccount1 = transfer(accounts, "mati", "mati", 5);
        assertEquals(10, updatedAccount1.get("mati"));
        assertEquals(20, updatedAccount1.get("juan"));
    }
}