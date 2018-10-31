package Ex07;

public class IntSet {
	
	private int num;	// 집합의 요소 개수
	private int max; 	// 집합의 최대 개수
	private int[] set;	// 집합 본체
	
	public IntSet() {
		this(16);
	}
	
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[capacity];
		}
		catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	// 잡합에서 n을 검색한다.
	public int indexOf(int n) {
		for(int i=0; i<num; i++) {
			if(n==set[i])
				return i;
		}
		return -1;
	}
	
	// 집합에 n이있는지 없는지 확인한다.
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}
	
	// 집합에 n을 추가합니다.
	public boolean add(int n) {
		if(num >= max || contains(n)) {
			return false;
		} 
		else {
			set[num++] = n;
			return true;
		}
	}
	
	// 집합에서 n을 삭제합니다.
	public boolean remove(int i) {
		int idx = indexOf(i);
		
		if(num <= 0 || idx == -1) {
			return false;
		} 
		else {
			set[idx] = set[--num];
			return true;
		}
	}
	
	// 잡합 s에 복사합니다.
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num;	// 복사할 요소 개수
		for(int i=0; i<n; i++) {
			s.set[i] = set[i];
		}
		s.num = n;
	}
	
	// 집합 s를 복사합니다.
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i=0; i<n; i++) {
			set[i] = s.set[i];
		}
		num = n;
	}
	
	// 집합 s와 같은지 확인합니다.
	public boolean equalsTo(IntSet s) {
		if(num != s.num)
			return false;
		
		for(int i=0; i<num; i++) {
			int j=0;
			for(; j<s.num; j++) {
				if(set[i] == s.set[j])
					break;
			}
			if(j==s.num)
				return false;
		}
		return true;
	}
	
	// 집합 s1과 s2의 합집합을 복사합니다.
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);
		for(int i=0; i<s2.num; i++)
			add(s2.set[i]);
	}
	
	public boolean isEmpty() {
		return (num <= 0) ? true : false;
	}
	
	public boolean isFull() {
		return (num >= max) ? true : false;
	}
	
	public void clear() {
		num = 0;
	}
	
	// "{ a b c }" 형식의 문자열로 표현을 바꿉니다.
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		for(int i=0; i<num; i++) {
			temp.append(set[i] + " ");
		}
		temp.append("}");
		return temp.toString();
	}
	
}
