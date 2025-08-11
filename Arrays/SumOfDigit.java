import java.util.*;
public class SumOfDigit{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int a[] = {1,2,3,5,7,10,11,15};

    int target = 15;

    int left = 0;
    int right = a.length - 1;
    while(left < right){
      int currentsum = a[left] + a[right];
      if(currentsum == target){
        System.out.println(a[left]+","+a[right]);
        break;
      }
      else if(currentsum < target){
        left++;
      }else{
        right--;
      }
    }
  }
}