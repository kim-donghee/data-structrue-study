package Ex02;

public class PrimeNumber02 {
	
	public static void main(String[] args) {
		int ptr = 0;
		int counter = 0;
		int[] prime = new int[512];
		
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for(int n = 5; n <= 1000; n+=2) {
			boolean flag = false;
			for(int i=1; prime[i] * prime[i] <= n; i++) {
				counter += 2;
				if(n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}
		
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("소수 개수 : " + ptr);
		System.out.println("연산 횟수 : " + counter);
		
	}
	
}
