package inheritance.multilevelinheritance;

public class Dog extends Mamal {
  String breed;
  String name;

  public void bark() {
    makeSound();
  }

  public void eat() {
    System.out.println("Dog eat");
  }
}
