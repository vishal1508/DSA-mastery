package inheritance.herachicleinheritance;

public class Circle extends Shape {

  public void circleArea(int readius) {

    double a = Math.PI * readius;
    System.out.println("Circle Area is :=> " + a);
    // super.shape();
  }
}
