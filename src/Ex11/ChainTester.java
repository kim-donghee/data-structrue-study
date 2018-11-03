package Ex11;


public class ChainTester {

	public static void main(String[] args) {
		ChainHash<Integer, Data> hash = new ChainHash<>(13);
		hash.add(13, new Data(13, "kim"));
		hash.add(100, new Data(100, "kim"));
		hash.add(73, new Data(73, "dong"));
		hash.add(175, new Data(175, "hee"));
		hash.add(23, new Data(23, "mike"));
		hash.add(12, new Data(12, "John"));
		hash.add(53, new Data(53, "DDang"));
		hash.add(89, new Data(89, "???"));
		hash.add(85, new Data(85, "Dock"));
		hash.add(80, new Data(80, "Triple"));
		hash.add(87, new Data(87, "nine"));
		hash.add(91, new Data(91, "miss"));
		
		System.out.println(hash.search(100));
		
		System.out.println(hash.remove(100));
		
		System.out.println(hash.search(100));
		
		hash.dump();
	}

}

class Data {
	private Integer no;
	private String name;		
	
	public Data(Integer no, String name) {
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
