package Ex02;

public class PrimeNumber01 {

	public static void main(String[] args) {
		int ptr = 0;
		int counter = 0;
		int[] prime = new int[512];
		
		for(int n = 2; n <= 1000; n++) {
			int i;
			
			for(i = 2; i < n; i++) {
				counter++;
				if(n % i == 0) break;
			}
			if(n == i) {
				prime[ptr++] = n;
			}			
		}
		
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("소수 개수 : " + ptr);
		System.out.println("연산 횟수 : " + counter);
		
	}

}
