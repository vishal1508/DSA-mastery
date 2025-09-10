import java.util.*;
public class BinarySearch{
	public static void main(String[] args){
		int a[] = {10,20,30,40,50,60,70};
		System.out.println(Arrays.toString(a));
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number To Search := ");
		int searchNumber = sc.nextInt();
		int left = 0;
		int right = a.length - 1;
		boolean found = false;
		while(left <= right){
			int mid = (left + right+1 )/2;
			if(a[mid] == searchNumber){
				System.out.printf("%d found at index %d ",searchNumber,mid);
				found = true;
				break;
			}else if(a[mid] > searchNumber){
				right = mid-1;
			}else if(a[mid] < searchNumber){
				left = mid+1;
			}
		}	
		if(!found){
			System.out.printf("%d is not found in give Array",searchNumber);
		}
	}
}
