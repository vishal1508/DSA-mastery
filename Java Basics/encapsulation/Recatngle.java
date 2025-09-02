package encapsulation;

public class Recatngle {
  private int length;
  private int width;

  public void setLengthAndWidth(int length,int width){
    this.length = length;
    this.width = width;
  }
  public int getArea(){
    return this.length * this.width;
  }
}
