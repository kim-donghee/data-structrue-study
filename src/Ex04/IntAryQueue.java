package Ex04;

public class IntAryQueue {
	
	private int max;	// 큐 용량
	private int num;	// 현재 데이터 수
	private int[] que;	// 큐
	private int front;	// 첫 번째 요소 커서
	private int rear;	// 마지막 요소 커서
	
	public class EmptyIntStackException extends RuntimeException { }
	
	public class OverflowIntStackException extends RuntimeException { }	
	
	public IntAryQueue() {
		this(16);
	}
	
	public IntAryQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enque(int x) {
		if(isFull()) {
			throw new OverflowIntStackException();
		}
		que[rear++] = x;
		num++;
		if(rear == max) {
			rear = 0;
		}
		return x;
	}
	
	public int deque() {
		if(isEmpty()) {
			throw new EmptyIntStackException();
		}
		int x = que[front++];
		num--;
		if(front == max) {
			front = 0;
		}
		return x;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyIntStackException();
		}
		int x = que[front];
		return x;
	}
	
	public int indexOf(int x) {		
		for(int i=0; i<num; i++) {
			int idx = (i + front) % max;
			if(que[idx] == x)
				return idx;
		}
		return -1;
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		System.out.print("queue values : [");
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			System.out.print(que[idx] + ", ");
		}
		System.out.println("]");
		
	}
	
}
