package receipts;

public class Item {
  private final int numberID;
  private String name;
  private double price;
  private String date;
  private int count;

  public Item(int numberID, String name) {
    this.numberID = numberID;
    this.name = name;
  }

  public Item(int numberID, String name, double price, String date, int count) {
    this.numberID = numberID;
    this.name = name;
    this.price = price;
    this.date = date;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getCount() {
    return count;
  }

  @Override
  public String toString() {
    return "Item{" +
           "numberID=" + numberID +
           ", name='" + name + '\'' +
           ", price=" + price +
           ", date='" + date + '\'' +
           '}';
  }
}
