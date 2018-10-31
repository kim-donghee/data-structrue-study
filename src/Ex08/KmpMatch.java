package Ex08;

public class KmpMatch {
	
	static int kmpMatch(String txt, String pat) {
		int pt = 1;		// txt 커서
		int pp = 0;		// pat 커서
		int[] skip = new int[pat.length() + 1];		// 건너뛰기 표
		
		// 건너뛰기 표를 만듬.
		skip[pt] = 0;
		while(pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			}
			else if(pp == 0) {
				skip[++pt] = pp;
			}
			else {
				pp = skip[pp];
			}
		}
		
		pt = pp = 0;
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			}
			else if(pp == 0) 
				pt++;
			else
				pp = skip[pp];
		}
		
		if(pp==pat.length())
			return pt-pp;
		return -1;
		
	}

	public static void main(String[] args) {
//		System.out.println(kmpMatch("abcde", "abb"));
//		System.out.println(kmpMatch("abcde", "abc"));
//		System.out.println(kmpMatch("abcde", "bcd"));
//		System.out.println(kmpMatch("abcde", "cde"));
		System.out.println(kmpMatch("abcdacde", "cde"));
//		System.out.println(kmpMatch("abccdef", "cde"));
	}

}
