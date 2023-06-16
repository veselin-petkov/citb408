package com.company;
import receipts.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Shop Kaufland = new Shop();
        Item meat = new Item(12, "Meat", 12.6, "12/06/2021", 10);
        Item milk = new Item(15, "Milk", 1.8, "20/09/2020", 20);
        Item chocolate = new Item(8, "Chocolate", 2.5, "10/02/2022", 35);

        Cashier ivan = new Cashier(1234, "Ivan");
        Cashier mitko = new Cashier(5175, "Mitko");

        //Delivery products in shop
        Kaufland.storeItem(meat);
        Kaufland.storeItem(milk);
        Kaufland.storeItem(chocolate);

        Kaufland.displayList();

        Kaufland.addCashierToList(ivan);
        Kaufland.addCashierToList(mitko);

        System.out.println(Kaufland.getCashierList());
        System.out.println();

        //Store products in shopping cart
        HashMap<Item, Integer> cart = new HashMap<>();

        CashDesk first = new CashDesk(ivan, cart);

        try {
            first.addItemToList(meat, 19);
            first.addItemToList(chocolate, 14);
        } catch (NotEnoughQuantity e) {
            e.printStackTrace();
        }

        Receipt receipt = first.getReceipt(cart, ivan);

        System.out.println(receipt);

        receipt.writeReceipt();

        cart.clear();

        cart.put(milk, 7);
        cart.put(chocolate, 3);
        cart.put(meat, 1);

        System.out.println();
        Receipt receipt2 = first.getReceipt(cart, ivan);

        System.out.println(receipt2);

        receipt2.writeReceipt();

        //Count of all receipts
        System.out.println(first.getReceipts());


        HashMap<Item, Integer> card2 = new HashMap<>();

        CashDesk second = new CashDesk(mitko, card2);

        card2.put(meat, 2);
        card2.put(milk, 4);

        Receipt receipt3 = second.getReceipt(card2, mitko);

        receipt3.writeReceipt();

        System.out.println();
        System.out.println("---------- Read from file -------");
        System.out.println();

        List<String> receiptContent = receipt3.readReceipt("3.txt");

        for (String line : receiptContent) {
            System.out.println(line);
        }

        System.out.println();

        HashMap<Item, Integer> cart3 = new HashMap<>();
        Cashier petar = new Cashier(2517, "Petar");

        CashDesk third = new CashDesk(petar, cart3);

        Thread thread1 = new Thread(first, "First");
        Thread thread2 = new Thread(second, "Second");
        Thread thread3 = new Thread(third, "Third");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
