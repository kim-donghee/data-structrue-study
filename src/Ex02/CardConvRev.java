package Ex02;

public class CardConvRev {
	
	static int cardConvR(int x, int r, char[] d) {
		
		String das;
		
		int digits = 0;
		String dchar = "0123456789ABCDEF";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x!= 0);
		
		return digits;		
	}
	
	public static void main(String[] args) {
		char chArr[] = new char[32];
		int i = cardConvR(30, 2, chArr) - 1;
		for(; i>=0; i--) {
			System.out.print(chArr[i]);
		}
	}

}
