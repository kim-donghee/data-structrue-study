package Ex01;

public class MedianTest {
	
	static int med3(int a, int b, int c) {		
		int ret;
		
		if(a >= b)
			if(b >= c)
				ret = b;
			else if(a <= c)
				ret = a;
			else
				ret = c;
		else if(a > c)
			ret = a;
		else if(b > c)
			ret = c;
		else 
			ret = b;
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(med3(1, 2, 3));
		System.out.println(med3(2, 1, 3));
		System.out.println(med3(1, 3, 2));
	}

}
