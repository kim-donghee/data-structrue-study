package ex03;

public class BinSearch {
	
	static int binSearch(int[] a, int n, int key) {
		
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if(a[pc] == key)
				return pc;
			else if(a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while(pl <= pr);
		
		return -1;		
	}
	
	public static void main(String[] args) {
		
		int key = 100;
		int[] x = { 2, 4, 7, 8, 10, 14, 15, 40, 100 };
		
		int idx = binSearch(x, x.length, key);
		
		if (idx == -1)
			System.out.println(key + "의 요소가 없습니다");
		else
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");		
		
	}

}
