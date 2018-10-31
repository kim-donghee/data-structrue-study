package Ex08;

public class BFmatch {
	
	static int bfmatch(String txt, String pat) {		
		int pt = 0;		// txt 커서
		int pp = 0;		// pat 커서
		
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			}
			else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		if(pp == pat.length())
			return pt - pp;
		return -1;		
	}

	public static void main(String[] args) {
		System.out.println(bfmatch("abcde", "abb"));
		System.out.println(bfmatch("abcde", "abc"));
		System.out.println(bfmatch("abcde", "bcd"));
		System.out.println(bfmatch("abcde", "cde"));
		System.out.println(bfmatch("abcdacde", "cde"));
		System.out.println(bfmatch("abccdef", "cde"));
	}

}
