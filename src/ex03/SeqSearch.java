package ex03;

public class SeqSearch {
	
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
	static int seqSearch(int[] a, int n, int key) {
		
//		int i = 0;		
//		while(true) {
//			if (i == n)
//				return -1;
//			if (a[i] == key)
//				return i;
//			i++;
//		}
		
		for(int i=0; i<n; i++) {
			if(a[i] == key)
				return i;
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int key = 5;
		int[] x = { 4, 6, 2, 3, 1, 7, 5 };
		
		int idx = seqSearch(x, x.length, key);
		
		if (idx == -1)
			System.out.println(key + "의 요소가 없습니다");
		else
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");
	}

}
