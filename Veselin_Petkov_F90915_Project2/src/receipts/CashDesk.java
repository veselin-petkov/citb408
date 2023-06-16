package receipts;

import java.io.*;
import java.util.*;

public class CashDesk extends Thread implements Payment {
  private Cashier cashier;
  private HashMap<Item, Integer> itemList = new HashMap<>();
  private static int receipts = 0;

  public CashDesk(Cashier cashier, HashMap<Item, Integer> itemList) {
    this.cashier = cashier;
    this.itemList = itemList;
  }

  public int getReceipts() {
    return receipts;
  }

  public void addItemToList(Item item, int count) throws NotEnoughQuantity {
      if (count > item.getCount()) {
          throw new NotEnoughQuantity(count, item.getCount());
      } else {
          itemList.put(item, count);
      }
  }

  public Receipt getReceipt(HashMap<Item, Integer> list, Cashier cashier) {
    Receipt receipt = new Receipt(cashier, list);
    receipts++;

    return receipt;
  }

  public void run() {
    try {
      Thread.currentThread().setName("Cash Desk");
      System.out.println(Thread.currentThread().getName() + " with cashier's name: " + cashier.getName());

      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Error");
    }
  }

  @Override
  public double payment() {
    double results = 0;

    for (Item item : itemList.keySet()) {
      int value = itemList.get(item);
      results += item.getPrice() * value;
    }

    return results;
  }

  @Override
  public String toString() {
    return "CashDesk{" +
           "cashier=" + cashier +
           ", itemList=" + itemList +
           '}';
  }
}
