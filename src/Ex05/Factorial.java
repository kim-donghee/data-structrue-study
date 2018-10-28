package Ex05;

public class Factorial {
	
	static int factorial(int n) {
		if(n > 0)
			return factorial(n - 1) * n;
		else
			return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

}
