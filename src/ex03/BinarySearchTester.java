package ex03;

import java.util.Arrays;

public class BinarySearchTester {

	public static void main(String[] args) {
		
		int key = 111;
		int[] x = { 34, 50, 70, 100, 110, 112, 114, 140, 200 };
		
		int idx = Arrays.binarySearch(x, key);
		
		if (idx <= -1)
			System.out.println(key + "의 요소가 없습니다");
		else
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");
		
		System.out.println(idx);
	}

}
