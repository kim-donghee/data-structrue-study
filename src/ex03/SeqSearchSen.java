package ex03;

public class SeqSearchSen {

	static int seqSearchSen(int[] a, int n, int key) {
		
		int i = 0;
		a[n] = key;
		
//		while(true) {
//			if(a[i] == key)
//				break;
//			i++;
//		}
		
		for(i=0; i<=n; i++) {
			if(a[i] == key)
				break;
		}
		
		return i == n ? -1 : i;
		
	}
	
	public static void main(String[] args) {
		
		int key = 5;
		int[] x = { 4, 6, 2, 3, 1, 7, 1, 0 };
		
		int idx = seqSearchSen(x, x.length - 1, key);
		
		if (idx == -1)
			System.out.println(key + "의 요소가 없습니다");
		else
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");		
	}

}
