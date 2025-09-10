import java.util.Scanner;
public class LinearSearch{
	public static void main(String... args){
		int[] a = {23,24,32,12,10,34};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number To Search := ");		
		int searchNumber = sc.nextInt();
		int i = 0;
		boolean found = false;
		while(i < a.length){	
		 if(a[i] == searchNumber){
				System.out.printf("%d is Found at index %d th",searchNumber,i);
				found = true;
				break;
			}
			i++;
		}
		if(!found){
			            System.out.printf("%d is not found in the array%n", searchNumber);
		}
}}
