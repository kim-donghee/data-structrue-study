package Ex06;

public class BubbleSort {
	
	static void bubbleSort(int[] a) {
		
		int n = a.length;
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>i; j--) {
				if(a[j-1] > a[j]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		int n = 10;
		int arr[] = new int[n]; 
		
		for(int i=0; i<n; i++) {
			arr[i] = (int) (Math.random()*10) + 1;
		}
		
		bubbleSort(arr);
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
