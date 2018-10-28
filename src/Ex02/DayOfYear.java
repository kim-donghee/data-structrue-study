package Ex02;

public class DayOfYear {
	
	static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }	// 운년
	};
	
	// 윤년
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	// 일 수
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		
		for(int i=0; i < m-1; i++) {
			days += mdays[isLeap(y)][i];
		}
		return days;		
	}
	
	public static void main(String[] args) {
		
		int y = 2016;
		int m = 3;
		int d = 1;
		
		System.out.println("년 : " + y);
		System.out.println("월 : " + m);
		System.out.println("일 : " + d);
		System.out.printf("그 해 %d일째입니다.", dayOfYear(y, m, d));
		
	}

}
