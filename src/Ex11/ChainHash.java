package Ex11;

import java.util.HashSet;
import java.util.Set;

public class ChainHash<K, V> {
	// 해시를 구성하는 노드
	class Node<K, V> {
		private K key;				// 키 값
		private V data;				// 데이터
		private Node<K, V> next;	// 다음 노드에 대한 참조
		
		Node(K key, V data, Node<K, V> next) {
			super();
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		// 키 값을 반환합니다.
		K getKey() {
			return key;
		}
		
		// 데이터를 반환합니다.
		V getValue() {
			return data;
		}
		
		@Override
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;			// 해시 크기
	private Node<K, V>[] table;	// 해시 테이블
	
	public ChainHash() {
		this(16);
	}

	public ChainHash(int capacity) {
		try {
			this.table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}	
	
	// 해시 값을 구함
	public int hashValue(K key) {
		return key.hashCode() % size;
	}
	
	// 키 값 key를 갖는 요소의 검색(데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key);
		Node<K, V> p = table[hash];
		
		while(p != null) {
			if(p.getKey().equals(key))
				return p.getValue();
			p = p.next;
		}
		return null;
	}
	
	// 키 값 key, 데이터 data를 갖는 요소의 추가
	public boolean add(K key, V data) {
		int hash = hashValue(key);
		Node<K, V> p = table[hash];
		
		while(p!= null) {
			if(p.getKey().equals(key))
				return false;
			p = p.next;
		}
		
		Node<K, V> temp = new Node<>(key, data, table[hash]);
		table[hash] = temp;
		return true;		
	}
	
	// 키 값 key, 데이터 data를 갖는 요소의 삭제
	public boolean remove(K key) {
		int hash = hashValue(key);		// 삭제할 데이터의 해시 값
		Node<K, V> p = table[hash];		// 선택 노드
		Node<K, V> pp = null;	// 바로 앞의 선택 노드
		
		while(p != null) {
			if(p.getKey().equals(key)) {	// 찾으면
				if(pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return true;
			}
			pp = p;
			p = p.next;					// 다음 노드
		}		
		return false;
	}
	
	// 해시 테이블을 덤프()
	public void dump() {
		for(int i=0; i<size; i++) {
			Node<K, V> p = table[i];
			System.out.printf("%02d ", i);
			while(p != null) {
				System.out.printf(" -> %s (%s) ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}

}
