package Ex04;

public class InAryQueueTester {
	
	public static void main(String[] args) {
		
		IntAryQueue q = new IntAryQueue(5);		
		System.out.println("isEmpty : " + q.isEmpty());
		System.out.println("indexOf(1) : " + q.indexOf(1));
		q.enque(1); q.enque(3); q.enque(4); q.enque(2); q.enque(7);
		
		System.out.println("----queue test-----");
		q.dump();
		System.out.println("capacity : " + q.capacity());
		System.out.println("size : " + q.size());
		System.out.println("peek : " + q.peek());
		System.out.println("deque : " + q.deque());
		System.out.println("deque : " + q.deque());
		System.out.println("deque : " + q.deque());
		System.out.println("peek : " + q.peek());
		System.out.println("size : " + q.size());
		System.out.println("enque(1) : " + q.enque(20));
		System.out.println("indexOf(1) : " + q.indexOf(20));
		System.out.println("indexOf(10) : " + q.indexOf(10));
		System.out.println("isEmpty : " + q.isEmpty());
		System.out.println("isFull : " + q.isFull());
		q.dump();
		System.out.println("-------------------");
		
	}

}
