import java.util.Arrays;

public class TwoSum {
  public static void main(String[] args){
    int a[] = {3,2,4};
    // int a[] = {1,2,3,5,7,10,11,15};
    Arrays.sort(a);
    System.out.println(a[0]);
    int left = 0;
    int right = a.length - 1;
    int target = 6;
    while(left < right){
      int currentSum = a[left] + a[right];

      if(currentSum == target){
        System.out.println(left+""+right);
        System.out.printf("This is the value %d and %d which has sum is  equal to target %d",a[left],a[right], target);
        break;
      }else if(currentSum < target){
        left++;
      }
      else{
        right--;
      }
    }
  }
}
