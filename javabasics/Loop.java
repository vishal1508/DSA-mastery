public class Loop {
  public static void main(String[] args){
    //for loop
    for(int i = 1; i <= 10; i++){
      // System.out.printf("7 * %d = %d\n",i,7*i);
    }
    System.out.println("");
    //while loop
    int i = 1; 
    while(i <= 10){
      // System.out.printf("8 * %d = %d\n",i,8*i);
      i++;
    }
    
    //do while
    
    int a = 1;
    do{
      System.out.printf("9 * %d = %d\n",a,9*a);
      a++;
    }while( a < 10);
    // Beginner Level (For Loop, While Loop, Do-While)

    // Write a program to print numbers from 1 to 10 using a loop.
    System.out.println("1 to 10 number");
    for(int n = 1; n <= 10;n++){
      System.out.println(n);
    }

    // Write a program to print the sum of the first N natural numbers.
    int sum = 0;
    for(int n = 1; n <= 10; n++){
      sum = sum + n;
    }
    System.out.println("sum of n natural number is :=> "+sum);
    // Write a program to print the factorial of a number.
    int mul = 1;
    for(int n = 5; n > 0; n--){
      mul = mul * n;
    }
    System.out.println("Factorial of 5 is :=> "+mul);

    // Write a program to print all even numbers between 1 and 100.
    System.out.println("1 to 100 even numbers is ");
    int n = 1;
    while(n < 100){
      if(n % 2 == 0){
        System.out.println(n);
      }
      n++;
    }
    // Write a program to print all odd numbers between 1 and 100.
    System.out.println("1 to 100 odd numbers is ");
    for(int x = 1; x <=100; x++){
      if(x % 2 != 0){
        System.out.println(x);
      }
    }
    // Write a program to calculate the sum of digits of a number.
    int num = 12345;
    int sumOfDigit = 0;
    while(num > 0){
      int d = num % 10;
      sumOfDigit = sumOfDigit + d;
      num = num / 10;
    }
    System.out.println("Sum of Digits of Number :=> "+sumOfDigit);

    // Write a program to reverse a number using a loop.
    int g = 12345;
    System.out.print("\nReverse Number is :=> ");
    while(g > 0){
      int d = g % 10;
      System.out.print(d);
      g = g / 10;
    }
    // Write a program to check if a number is a palindrome (same forward & backward).
    int numb = 121;
    String reverseNum = "";
    int originNumber = numb;
    while(numb > 0){
      int d = numb % 10;
      // System.out.println(String.valueOf÷(d).getClass().getSimpleName());
      // String s = String.valueOf(d);
      reverseNum +=d ;
      numb = numb / 10;
    }
    System.out.printf("\n%d & %s is palindrome := %b  ",originNumber,reverseNum,(String.valueOf(originNumber).equals(reverseNum)));
    // Write a program to check whether a number is a prime number.

    int isPrimeNum = 7;
    int count = 0;
    for(int p = 1; p <= isPrimeNum; p++){
      if(isPrimeNum % p == 0)
      {
        count++;
      }
    }
    if(count == 2){
      System.out.printf("\n%d is primeNumber and count is := %d",isPrimeNum,count);
    }else{
      System.out.printf("\n%d is not prime nunber and count is := %d",isPrimeNum,count);
    }


  }
}
