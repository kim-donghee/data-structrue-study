package Ex06;

public class QuickSort {
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;				// 배열의 왼쪽 커서
		int pr = right;				// 배열의 오른쪽 커서
		int x = a[(pl + pr) / 2];	// 피벗
		
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr) {
				int tmp = a[pl];
				a[pl] = a[pr];
				a[pr] = tmp;
				pl++; pr--;
			}
		} while(pl <= pr);
		
		if(left < pr) quickSort(a, left, pr);
		if(right > pl) quickSort(a, pl, right);
	}

	public static void main(String[] args) {
		int arr[] = { 8, 4, 10, 1, 5, 7, 6, 2, 2, 10 };
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}		
		System.out.println();
		
		quickSort(arr, 0, arr.length - 1);
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
