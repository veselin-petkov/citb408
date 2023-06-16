package receipts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Receipt implements Payment {
  private final int num;
  private static int number = 1;
  private Cashier cashier;
  private LocalDate date;
  private HashMap<Item, Integer> itemList = new HashMap<>();
  private double totalPrice;

  public Receipt() {
    this.num = number;
  }


  public Receipt(Cashier cashier, HashMap<Item, Integer> itemList) {
    this.num = number;
    this.cashier = cashier;
    this.date = LocalDate.now();
    this.itemList = itemList;
    this.totalPrice = this.payment();
    number++;
  }

  public int numberOfReceipts() {
    return num;
  }

  public void writeReceipt() {
    try (FileWriter fileWriter = new FileWriter(this.num + ".txt")) {
      fileWriter.write("Receipt " + this.num + System.lineSeparator());
      fileWriter.write("Cashier " + this.cashier + System.lineSeparator());
      fileWriter.write("Date " + this.date + System.lineSeparator());
      fileWriter.write("ItemList " + this.itemList + System.lineSeparator());
      fileWriter.write("TotalPrice " + this.totalPrice + System.lineSeparator());

      fileWriter.write("Total Value Of Receipts " + this.numberOfReceipts());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> readReceipt(String fileName) {
    List<String> receiptLines = new ArrayList<>();
    try (FileReader fileReader = new FileReader(fileName)) {
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        receiptLines.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return receiptLines;
  }

  @Override
  public double payment() {
    double sum = 0;
    for (Item item : itemList.keySet()) {
      int value = itemList.get(item);
      sum += item.getPrice() * value;
    }
    return sum;
  }

  @Override
  public String toString() {
    return "Receipt{" +
           "num=" + num +
           ", cashier=" + cashier +
           ", date=" + date +
           ", itemList=" + itemList +
           ", totalPrice=" + totalPrice +
           '}';
  }
}
