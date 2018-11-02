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
		tree.add(73, new Data(73, "dong"));
		tree.add(175, new Data(175, "hee"));
		tree.add(23, new Data(23, "mike"));
		tree.add(12, new Data(12, "John"));
		tree.add(53, new Data(53, "DDang"));
		tree.add(89, new Data(89, "???"));
		tree.add(85, new Data(85, "Dock"));
		tree.add(80, new Data(80, "Triple"));
		tree.add(87, new Data(87, "nine"));
		tree.add(91, new Data(91, "miss"));
		
		System.out.println(tree.search(100));
		
		tree.remove(100);
		
		tree.print();
		
	}

}
