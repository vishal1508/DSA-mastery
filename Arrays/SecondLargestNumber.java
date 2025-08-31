public class SecondLargestNumber {
  public static void main(String[] args){
    int a [] = {25,169};

    int firstMax = a[0];
    int secondMax = a[1];

    if(a[0] < a[1]){
      firstMax = a[1];
      secondMax = a[0];
    }

    for(int i = 2; i < a.length - 1; i++){
      if(a[i] > firstMax){
        secondMax = firstMax;
        firstMax = a[i];
      }else if(a[i] > secondMax){
        secondMax = a[i];
      }
    }
    System.out.printf("First maximum number is := %d \t",firstMax);
    System.out.printf("Second maximum number is := %d \t",secondMax);
  }
}
