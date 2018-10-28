package Ex05;

public class EuclidGCD {
	
	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else 
			return gcd(y, x%y);
	}

	public static void main(String[] args) {
		int x = 21; int y = 15;
		int gcd = gcd(x, y);
		System.out.printf("%d와 %d의 최대공약수는 %d입니다.", x, y, gcd);
	}

}
