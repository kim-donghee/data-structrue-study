package Ex04;

public class IntStack {
	
	private int max;	// 스택 용량
	private int ptr;	// 스택 포인터
	private int stk[];	// 스택
	
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
	
	public void clear() {
		ptr = 0;
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
			for(int i=0; i<ptr; i++) {
				System.out.print(stk[i] + ", ");
			}
			System.out.println("]");
		}
	}
	
	
}
