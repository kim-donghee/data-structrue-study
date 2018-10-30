package Ex06;

public class Partition {
	
	static void partition(int[] a) {
		
		int n = a.length;
		
		int pl = 0;			// 왼쪽 커서
		int pr = n - 1;		// 오른쪽 커서
		int x = a[n / 2];	// 피벗
		
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
	}

	public static void main(String[] args) {
		int arr[] = { 8, 4, 10, 1, 5, 7, 6, 2, 2, 10 };
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}		
		System.out.println();
		
		partition(arr);
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}

}
