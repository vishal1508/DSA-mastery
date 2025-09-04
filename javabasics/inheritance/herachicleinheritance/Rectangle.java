package inheritance.herachicleinheritance;

public class Rectangle extends Shape {
  public void rectangleArea(int width, int length) {
    super.shape();
    System.out.println("the Rectagle area is :> " + (width * length));
  }

}
