package implementation.exceptions;

public class ExpiredDateException extends RuntimeException {

  public ExpiredDateException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return "ExpiredDateException{" + getMessage() + "}";
  }

}
