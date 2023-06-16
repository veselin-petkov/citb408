package receipts;

public class NotEnoughQuantity extends Exception {
  private int countForCart;
  private int countOfShop;

  public NotEnoughQuantity(int countForCart, int countOfShop) {
    this.countForCart = countForCart;
    this.countOfShop = countOfShop;
  }

  @Override
  public String toString() {
    return "NotEnoughQuantity{" +
           "countForCart=" + countForCart +
           ", countOfShop=" + countOfShop +
           '}';
  }
}
