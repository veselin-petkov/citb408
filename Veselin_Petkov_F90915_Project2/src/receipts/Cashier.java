package receipts;

public class Cashier {
  private final int numberID;
  private String name;

  public Cashier(int numberID) {
    this.numberID = numberID;
  }

  public Cashier(int numberID, String name) {
    this.numberID = numberID;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Cashier{" +
           "numberID=" + numberID +
           ", name='" + name + '\'' +
           '}';
  }
}
