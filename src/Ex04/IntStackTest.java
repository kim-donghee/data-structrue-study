package Ex04;

public class IntStackTest {

	public static void main(String[] args) {
		
		IntStack s = new IntStack();		
		System.out.println("isEmpty : " + s.isEmpty());
		System.out.println("indexOf(1) : " + s.indexOf(1));
		s.push(5); s.push(9); s.push(1); s.push(4); s.push(2);
		
		System.out.println("----stack test-----");
		s.dump();
		System.out.println("capacity : " + s.capacity());
		System.out.println("size : " + s.size());
		System.out.println("peek : " + s.peek());
		System.out.println("pop : " + s.pop());		
		System.out.println("size : " + s.size());
		System.out.println("indexOf(1) : " + s.indexOf(1));
		System.out.println("indexOf(10) : " + s.indexOf(10));		
		System.out.println("isFull : " + s.isFull());
		s.dump();
		System.out.println("-------------------");
	}

}
