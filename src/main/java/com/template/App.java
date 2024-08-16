package com.template;

import java.util.Collections;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if(amount > 0 && accounts.containsKey(account) == true) {
        int newAmount = accounts.get(account) + amount;
        accounts.put(account,newAmount);
        }
        return accounts;
    }
    public static Map<String, Integer> extract(Map<String, Integer> accounts, String account, int amount) {
        if(amount > 0 && accounts.containsKey(account) == true && accounts.get(account) > 0) {
            int newAmount = accounts.get(account) - amount;
            accounts.put(account, newAmount);
        }
        return accounts;
    }
    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String account1, String account2, int amount) {
        if(accounts.containsKey(account1) == true && accounts.containsKey(account2) == true && accounts.get(account1) > 0 && amount > 0 && !account1.equals(account2)) {
            int newAmount1 = accounts.get(account1) - amount;
            int newAmount2 = accounts.get(account2) + amount;
            accounts.put(account1, newAmount1);
            accounts.put(account2, newAmount2);
        }
        return accounts;
    }
}
