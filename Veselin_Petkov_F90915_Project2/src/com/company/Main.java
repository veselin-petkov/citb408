package com.company;

import implementation.CashDesk;
import implementation.Cashier;
import implementation.Goods;
import implementation.Receipt;
import implementation.Shop;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Shop Kaufland = new Shop();
    Goods meat = new Goods(12, "Meat", 12.6, Instant.parse("2023-06-12T00:00:00.00Z"), 10);
    Goods milk = new Goods(15, "Milk", 1.8, Instant.parse("2023-09-20T00:00:00.00Z"), 20);
    Goods chocolate = new Goods(8, "Chocolate", 2.5, Instant.parse("2024-02-10T00:00:00.00Z"), 35);

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
    HashMap<Goods, Integer> cart = new HashMap<>();

    CashDesk first = new CashDesk(ivan, cart);

    first.addItemToList(meat, 19);
    first.addItemToList(chocolate, 14);

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

    HashMap<Goods, Integer> cart2 = new HashMap<>();

    CashDesk second = new CashDesk(mitko, cart2);

    cart2.put(meat, 2);
    cart2.put(milk, 4);

    Receipt receipt3 = second.getReceipt(cart2, mitko);

    receipt3.writeReceipt();

    CashDesk fourthDesk = new CashDesk(mitko, cart);
    fourthDesk.addItemToList(meat, cart2.get(meat));
    fourthDesk.addItemToList(milk, cart2.get(milk));

    Receipt receipt4 = fourthDesk.getReceipt(cart, mitko);
    receipt4.writeReceipt();

    System.out.println();
    System.out.println("---------- Read from file -------");
    System.out.println();

    List<String> receiptContent = receipt3.readReceipt("3.txt");
    List<String> receiptFour = receipt4.readReceipt("4.txt");

    for (String line : receiptContent) {
      System.out.println(line);
    }

    for (String line : receiptFour) {
      System.out.println(line);
    }

    System.out.println();

    HashMap<Goods, Integer> cart3 = new HashMap<>();
    Cashier petar = new Cashier(2517, "Petar");

    CashDesk third = new CashDesk(petar, cart3);

    Thread thread1 = new Thread(first, "First");
    Thread thread2 = new Thread(second, "Second");
    Thread thread3 = new Thread(third, "Third");
    Thread thread4 = new Thread(fourthDesk, "Third");

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
}
