package Ex08;

public class BmMatch {
	
	static int bmMatch(String txt, String pat) {
		int pt;						// txt의 커서
		int pp;						// pat의 커서
		int txtLen = txt.length();	// txt의 문자 개수
		int patLen = pat.length();	// pat의 문자 개수
		int[] skip = new int[Character.MAX_VALUE + 1];	// 건너 뛰기 표
		
		// 건너뛰기 표 만들기
		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
			skip[pt] = patLen;
		}			
		for(pt = 0; pt < patLen - 1; pt++) {
			skip[pat.charAt(pt)] = patLen - pt - 1;
		}
		
		while(pt < txtLen) {
			pp = patLen - 1;
			
			while(txt.charAt(pt) == pat.charAt(pp)) {
				if(pp == 0) {
					return pt;	// 검색 성공
				}
				pp--;
				pt--;
			}			
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
			System.out.println(pt);
		}		
		return -1;				// 검색 실패
	}
	
	public static void main(String[] args) {
		System.out.println(bmMatch("abdeabdcde", "cde"));
	}

}
