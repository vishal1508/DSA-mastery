public class Recursion {
      public static void main(String[] args) {

        // int a
        printFibonaciSeries(6);
        // System.out.println(a);
    }

      public static int factorial(int n ){
          if(n == 1)  return 1;
          return n * factorial(n-1);
      }
      public static void print1toN(int n){
          if(n == 0) return;
          print1toN(n-1) ;
          System.out.println(n);


      }
      public static void printNto1(int n){
          if(n == 0) return;
          System.out.println(n);
          printNto1(n-1) ;

      }
      public static int firstSumOfNaturalNumber(int n){
          if(n == 1) return 1;
          return n + firstSumOfNaturalNumber(n-1) ;

      }
      public static int sumOfDigit(int n){
        if(n == 1) return 1;
        int d = n % 10;
        return  d+sumOfDigit(n/10);
      }
      public static int reverseNumber(int n){
        if(n == 1) return 1;
         int d = n % 10;
         System.out.print(d);
        return reverseNumber(n / 10);
      }

      public static int countNumber(int n ){
        if(n == 1) return n;
        int d = n % 10;
        int count = countNumber(n/10);
        count++;
        return count;
      }

      public static void printFibonaciSeries(int n ){
        if(n == 0) return;
        printFibonaciSeries( n -1);
        System.out.print(fibobaciNumber(n - 1)+",");
      }
      public static int fibobaciNumber(int n){
        if( n == 0) return 0;
        if(n == 1) return 1;
        return (fibobaciNumber( n - 1) + fibobaciNumber(n - 2));
      }
}
