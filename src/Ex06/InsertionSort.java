package Ex06;

public class InsertionSort {

	static int insertionSort(int[] a) {

		int n = a.length;
		int counter = 0;

		for(int i=1; i<n; i++) {
			int j;
			int tmp = a[i];

			for(j=i; j>0 && tmp < a[j-1]; j--) {
				counter++;
				a[j] = a[j-1];
			}			
			a[j] = tmp;
		}

		return counter;
	}

	public static void main(String[] args) {
		int arr[] = { 8, 4, 10, 9, 5, 7, 6, 2, 2, 10 };

		for(int v : arr) {
			System.out.print(v + ", ");
		}

		System.out.println("\n" + insertionSort(arr));

		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
