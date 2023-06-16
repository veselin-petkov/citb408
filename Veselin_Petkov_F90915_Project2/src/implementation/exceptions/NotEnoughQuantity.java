package implementation.exceptions;

public class NotEnoughQuantity extends RuntimeException {
  private int countForCart;
  private int countOfShop;
  private String productName;

  public NotEnoughQuantity(int countForCart, int countOfShop, String productName) {
    this.countForCart = countForCart;
    this.countOfShop = countOfShop;
    this.productName = productName;
  }

  @Override
  public String toString() {
    return "NotEnoughQuantity{" +
           "countForCart=" + countForCart +
           ", countOfShop=" + countOfShop +
           ", productName='" + productName +
           '}';
  }
}
