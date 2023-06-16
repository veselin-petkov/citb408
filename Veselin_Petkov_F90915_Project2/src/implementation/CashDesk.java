package implementation;

import implementation.exceptions.ExpiredDateException;
import implementation.exceptions.NotEnoughQuantity;
import java.time.Instant;
import java.util.HashMap;

public class CashDesk extends Thread implements Payment {
  private Cashier cashier;
  private HashMap<Goods, Integer> itemList = new HashMap<>();
  private int receipts = 0;

  public CashDesk(Cashier cashier, HashMap<Goods, Integer> itemList) {
    this.cashier = cashier;
    this.itemList = itemList;
  }

  public int getReceipts() {
    return receipts;
  }

  public void addItemToList(Goods goods, int count) {
    try {
      putItemsInList(goods, count);
    }
    catch (RuntimeException e) {
      e.printStackTrace();
    }
  }

  private void putItemsInList(Goods goods, int count) {

    if (count > goods.getQuantity()) {
      throw new NotEnoughQuantity(count, goods.getQuantity(), goods.getName());
    } else if (Instant.now().isAfter(goods.getDateOfExpire())) {
      throw new ExpiredDateException("Product: " + goods.getName() + " is out of date!");
    } else {
      itemList.put(goods, count);
    }
  }

  public Receipt getReceipt(HashMap<Goods, Integer> list, Cashier cashier) {
    Receipt receipt = new Receipt(cashier, list);
    receipts++;

    return receipt;
  }

  public void run() {
    try {
      Thread.currentThread().setName("Cash Desk");
      System.out.println(Thread.currentThread().getName() + " with cashier's name: " + cashier.getName());
      payment();
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Error");
    }
  }

  @Override
  public double payment() {
    double results = 0;

    for (Goods goods : itemList.keySet()) {
      int value = itemList.get(goods);
      results += goods.getPrice() * value;
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
