package Ex06;

public class SelectSort {

	static int selectionSort(int[] a) {
		
		int n = a.length;
		int counter = 0;
		
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				counter++;
				if(a[min] > a[j]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		return counter;		
	}
	
	public static void main(String[] args) {
		int arr[] = { 8, 4, 10, 9, 5, 7, 6, 2, 2, 10 };
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
		
		System.out.println("\n" + selectionSort(arr));
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
