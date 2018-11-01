package Ex09;

import java.util.Comparator;

public class DbLinkedList<E> {
	// 노드
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		public Node() {
			data = null;
			prev = next = this;
		}
		
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node<E> head;	// 머리 노트
	private Node<E> crnt;	// 선택 노드
	
	public DbLinkedList() {
		head = crnt = new Node<E>();
	}
	
	// 리스트가 비어있는
	public boolean isEmpty() {
		return head.next == head;
	}
	
	// 노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;	// 현재 스캔 중인 노드
		
		while(ptr != head) {
			if(c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;	// 검색 성공
			} 
			ptr = ptr.next;			// 다음 노드로 선택
		}		
		return null;				// 검색 실패
	}
	
	// 선택 노드를 출력한다.
	public void printCurrentNode() {
		if(isEmpty())
			System.out.println("선택 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	// 모든 노드를 출력한다.
	public void dump() {
		Node<E> ptr = head.next;		// 더미 노드의 다음 노드
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	// 모든 노드를 거꾸로 출력한다.
	public void dumpReverse() {
		Node<E> ptr = head.prev;		// 더미 노드의 앞쪽 노득
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.prev;
		}
	}
	
	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(isEmpty() || crnt.next==null)
			return false;	// 이동할 수 없음
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 하나 앞쪽으로 이동
	public boolean prev() {
		if(isEmpty() || crnt.prev==null)
			return false;	// 이동할 수 없음
		crnt = crnt.prev;
		return true;
	}
	
	// 선택 노드의 바로 뒤에 노드를 삽입
	public void add(E obj) {
		Node<E> node = new Node<>(obj, crnt, crnt.next);
		crnt.next = crnt.next.prev = node;
		crnt = node;
	}
	
	// 첫번째 노드의 삽입
	public void addFirst(E obj) {
		crnt = head;
		add(obj);
	}
	
	// 꼬리 노드의 삽입
	public void addLast(E obj) {
		crnt = head.prev;
		add(obj);
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if(crnt == head) crnt = head.next;
		}
	}
	
	// 노드 p를 삭제
	public void remove(Node<E> p) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(ptr == p) {
				crnt = p;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}
	
	// 머리 노드 삭제
	public void removeFirst() {
		crnt = head.next;
		removeCurrentNode();
	}
	
	// 꼬리 노드 삭제
	public void removeLast() {
		crnt = head.prev;
		removeCurrentNode();
	}
	
	// 모든 노드 삭제
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}

}
