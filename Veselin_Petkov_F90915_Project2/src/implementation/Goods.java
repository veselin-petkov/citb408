package implementation;

import java.time.Instant;

public class Goods {
  private final int numberID;
  private String name;
  private double price;
  private Instant dateOfExpire;
  private int quantity;

  public Goods(int numberID, String name, double price, Instant dateOfExpire, int quantity) {
    this.numberID = numberID;
    this.name = name;
    this.price = price;
    this.dateOfExpire = dateOfExpire;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public Instant getDateOfExpire() {
    return dateOfExpire;
  }

  @Override
  public String toString() {
    return "Item{" +
           "numberID=" + numberID +
           ", name='" + name + '\'' +
           ", price=" + price +
           ", date='" + dateOfExpire + '\'' +
           '}';
  }
}
