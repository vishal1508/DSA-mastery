package inheritance.herachicleinheritance;

public class HerachicleInheritance {
  public static void main(String[] args) {
    Circle c = new Circle();
    Rectangle r = new Rectangle();
    c.circleArea(4);
    c.shape();
    r.rectangleArea(12, 13);
    r.shape();
  }
}