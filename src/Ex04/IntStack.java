package Ex04;

public class IntStack {
	
	private int max;
	private int ptr;
	private int stk[];
	
	public class EmptyIntStackException extends RuntimeException { }
	
	public class OverflowIntStackException extends RuntimeException { }
	
	public IntStack() {
		this(16);
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError  e) { 
			max = 0;
		}				
	}
	
	public int push(int x) {
		if(isFull()) {
			throw new OverflowIntStackException();
		}
		
		return stk[ptr++] = x;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyIntStackException();
		}
		
		return stk[--ptr];
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyIntStackException();
		}
		
		return stk[ptr-1];
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	public boolean isFull() {
		return ptr>=max;
	}
	
	public void dump() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		} else {
			System.out.print("stack values : [");
			for(int i = ptr-1; i >= 0; i--) {
				System.out.print(stk[i] + ", ");
			}
			System.out.println("]");
		}
	}
	
	public int indexOf(int x) {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
		} else {
			for(int i = ptr-1; i>=0; i--) {
				if(stk[i] == x)
					return i;
			}
		}
		
		return -1;
	}
	
	
}
