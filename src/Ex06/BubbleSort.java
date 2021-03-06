package Ex06;

public class BubbleSort {
	
	static int bubbleSort(int[] a) {
		
		int counter = 0;
		int n = a.length;
		
		int k = 0;
		while(k < n-1) {
			int last = n-1;
			for(int j=n-1; j>k; j--) {
				counter++;
				if(a[j-1] > a[j]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					last = j;
				}
			}
			k = last;
		}
		
//		boolean exchg;
//		
//		for(int i=0; i<n; i++) {
//			exchg = false;
//			for(int j=n-1; j>i; j--) {
//				counter++;
//				if(a[j-1] > a[j]) {
//					int temp = a[j-1];
//					a[j-1] = a[j];
//					a[j] = temp;
//					exchg = true;
//				}
//			}
//			if(!exchg) break;
//		}
		
		return counter;
		
	}

	public static void main(String[] args) {
		
		int n = 10;
//		int arr[] = { 8, 4, 10, 9, 5, 7, 6, 2, 2, 10 };
		int arr[] = new int[n]; 
		
		for(int i=0; i<n; i++) {
			arr[i] = (int) (Math.random()*10) + 1;
		}
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
		
		System.out.println("\n" + bubbleSort(arr));
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
