package Ex06;

public class ShellSort02 {
	
	static int shellSort(int[] a) {
		
		int n = a.length;
		int counter = 0;
		
		int h;
		for(h=1; h<n/9; h=h*3+1) System.out.println(h);
		
		for(; h>0; h/=3) {
			for(int i=h; i<n; i++) {
				int j;
				int tmp = a[i];
				for(j=i-h; j>=0 && a[j] > tmp; j-=h) {
					counter++;
					a[j+h] = a[j];
				}
				a[j+h] = tmp;
			}
		}
		
		return counter;		
	}
	
	public static void main(String[] args) {
		int arr[] = { 8, 4, 10, 9, 5, 7, 6, 2, 2, 10, 1 };
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
		System.out.println();
		
		System.out.println(shellSort(arr));
		
		for(int v : arr) {
			System.out.print(v + ", ");
		}
	}
	
}
