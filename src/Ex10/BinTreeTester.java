package Ex10;

public class BinTreeTester {
	
	static class Data {
		private Integer no;
		private String name;
				
		public Data(Integer no, String name) {
			super();
			this.no = no;
			this.name = name;
		}

		Integer keyCode() {
			return no;
		}
		
		@Override
		public String toString() {
			return name;
		}		
	}

	public static void main(String[] args) {
		
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
		
		tree.add(100, new Data(100, "kim"));
		
		System.out.println(tree.search(100));
		
		tree.remove(100);
		
		tree.print();
		
	}

}
