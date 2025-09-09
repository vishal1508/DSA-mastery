public class LinearSearch{
	public static void main(String... args){
		int[] a = {23,24,32,12,10,34};
		
		int searchNumber = 12;
		int i = 0;
		while(i < a.length - 1){
			if(a[i] != searchNumber){
				i = i + 1;
			}else if(a[i] == searchNumber){
				System.out.printf("%d is Found at index %d th",searchNumber,i);
				break;
			}
		}
	}
}
