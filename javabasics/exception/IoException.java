package exception;

import java.io.FileReader;
import java.io.IOException;

public interface IoException {
  public static void main(String[] args) {
    try {
      FileReader f = new FileReader("text.tsxt");
    } catch (IOException e) {
      System.out.print(e);
    }

  }
}
