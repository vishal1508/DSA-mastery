package enumpractice;

enum Day {
  Sunday(1), Monday(2), TuesDay(2, "triday");

  private int num;
  private String message;

  Day(int num) {
    this.num = num;
    this.message = "N/A";
  }

  Day(int num, String message) {
    this.num = num;
    this.message = message;
  }

  public int getNum() {
    return this.num;
  }

  public String getMessage() {
    return this.message;
  }

}

public class EnumPractice {
  public static void main(String[] args) {
    Day d = Day.Monday;
    Day tuesday = Day.TuesDay;
    System.out.println(d.getNum() + "" + d.getMessage());
    System.out.println(tuesday.getNum() + "" + tuesday.getMessage());
  }
}
