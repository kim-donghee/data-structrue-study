package ex03;

import java.util.Arrays;
import java.util.Comparator;

public class PhysExamSearch {

	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public double getVision() {
			return vision;
		}

		public void setVision(double vision) {
			this.vision = vision;
		}

		@Override
		public String toString() {
			return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}
		
		// 오름차순
		public static final Comparator<PhyscData> HEIGHT_ORDER =
				new HeightOrderComapator();
		
		private static class HeightOrderComapator implements Comparator<PhyscData> {
			@Override
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : 
					(d1.height < d2.height) ? -1 : 0;
			}
		}

	}

	public static void main(String[] args) {
		
		PhyscData key = new PhyscData("", 162, 0.0);
		
		PhyscData[] x = {
			new PhyscData("이나령", 179, 0.3),
			new PhyscData("유지훈", 162, 1.3),	
			new PhyscData("김한걸", 168, 2.3),	
			new PhyscData("홍준기", 173, 0.2),	
			new PhyscData("전서형", 174, 1.5),	
			new PhyscData("이호연", 175, 2.4),	
		};
		
		int idx = Arrays.binarySearch(x, new PhyscData("", 162, 0.0), PhyscData.HEIGHT_ORDER);
		
		if (idx < 0)
			System.out.println(key + "의 요소가 없습니다");
		else {
			System.out.println(key + "은 x[" + idx + "]에 있습니다.");	
			System.out.println("찾은 데이터 : " + x[idx]);
		}
		
	}

}
