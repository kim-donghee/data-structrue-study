package ex03;

import java.util.Arrays;

public class StringBinarySearch {

	public static void main(String[] args) {
		
		String key = "abcd";
		String[] x = { "abc", "bbb", "ccc", "ddd" };
		
		int idx = Arrays.binarySearch(x, key);
		
		if (idx <= -1)
			System.out.println(key + "의 요소가 없습니다");
		else
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");	
		
		System.out.println(idx);
		
	}

}
