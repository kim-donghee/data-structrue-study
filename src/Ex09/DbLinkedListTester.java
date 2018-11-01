package Ex09;

import java.util.Comparator;

public class DbLinkedListTester {
	
	static class Data {
		private Integer no;
		private String name;		
		public Data() { }
		public Data(Integer no, String name) {
			this.no = no;
			this.name = name;
		}
		public Integer getNo() {
			return no;
		}
		public void setNo(Integer no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Data [no=" + no + ", name=" + name + "]";
		}		
	}
	
	// 회원번호로 순서를 매김
	public static final Comparator<Data> NO_ORDER = new NoOrderCamparator();	
	private static class NoOrderCamparator implements Comparator<Data> {
		@Override
		public int compare(Data d1, Data d2) {
			return d1.getNo() - d2.getNo();
		}		
	}
	
	// 회원번호로 순서를 매김
	public static final Comparator<Data> Name_ORDER = new NameOrderCamparator();	
	private static class NameOrderCamparator implements Comparator<Data> {
		@Override
		public int compare(Data d1, Data d2) {
			return d1.getName().compareTo(d2.getName());
		}		
	}
	
	public static void main(String[] args) {
		DbLinkedList<Data> list = new DbLinkedList<>();
		System.out.println(list.next());
		System.out.println("데이터 입력");
		list.addFirst(new Data(1, "kim"));
		list.addLast(new Data(2, "dong hee"));
		list.addFirst(new Data(3, "hello"));
		list.addLast(new Data(4, "monkey"));		
		list.dump();		
		System.out.println("--------------------------");
		
		System.out.println("데이터 삭제");
		list.removeFirst();
		list.removeLast();
		list.dump();
		System.out.println("--------------------------");
		
		System.out.println(new Data(1, "kim") + "데이터 검색");
		Data d1 = list.search(new Data(1, "kim"), NO_ORDER);
		System.out.println(d1 + "을 찾음");
		System.out.println("--------------------------");
		
		System.out.println("모두 삭제");
		list.clear();
		list.dump();
		System.out.println("--------------------------");		
		
	}

}
