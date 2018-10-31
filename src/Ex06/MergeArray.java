package Ex06;

public class MergeArray {
	
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while(pa < na && pb < nb) {
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		}
		
		while(pa < na) {
			c[pc++] = a[pa++];
		}
		
		while(pb < nb) {
			c[pc++] =  b[pb++];
		}
		
	}

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 6, 7 };
		int na = a.length;
		
		int b[] = { 1, 6, 12, 25 };
		int nb = b.length;
		
		int c[] = new int[na + nb];
		
		merge(a, na, b, nb, c);
		
		for(int v : c) {
			System.out.print(v + ", ");
		}		
		System.out.println();
		
	}

}
