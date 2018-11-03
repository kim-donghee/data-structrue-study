package Ex11;

import java.util.HashSet;

public class OpenHash<K, V> {

	// 버킷의 상태
	enum Status { OCCUPIED, EMPTY, DELETED }	// 데이터 저장, 비어있음, 삭제 마침

	// 버킷
	class Bucket<K, V> {
		private K key;			// 키 값
		private V data;			// 데이터
		private Status status;	// 상태

		Bucket() {
			status = Status.EMPTY;	// 버킷은 비어 있음
		}

		public void set(K key, V data, Status status) {
			this.key = key;
			this.data = data;
			this.status = status;
		}

		// 상태를 설정
		void setStatus(Status status) {
			this.status = status;
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

	private int size;				// 해시 테이블의 크기
	private Bucket<K, V>[] table;	// 해시 테이블
	
	public OpenHash() {
		this(13);
	}
	
	public OpenHash(int capacity) {
		try {
			table = new Bucket[capacity];
			for(int i=0; i<capacity; i++) {
				table[i] = new Bucket<>();
			}
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			
		}
	}
	
	// 해시 값을 구함
	public int hashValue(K key) {
		return key.hashCode() % size;
	}
	
	// 재해시 값을 구함
	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}
	
	// 키 값 key를 갖고 버킷을 검색
	private Bucket<K, V> searchNode(K key) {
		int hash = hashValue(key);		// 검색할 데이터의 해시 값
		Bucket<K, V> p = table[hash];	// 선택 버킷
		
		for(int i=0; p.status != Status.EMPTY && i < size; i++) {
			if(p.status == Status.OCCUPIED && p.getKey().equals(key))
				return p;
			hash = rehashValue(hash);
			p = table[hash];
		}
		return null;
	}

	// 키 값key를 갖는 요소의 검색(데이터를 반환)
	public V search(K key) {
		Bucket<K, V> p = searchNode(key);
		if(p != null)
			return p.getValue();
		else
			return null;		
	}
	
	// 키 값 key, 데이터 data를 갖는 요소의 추가
	public boolean add(K key, V data) {
		if(search(key) != null)
			return false;			// 이 키 값은 이미 등록됨
		
		int hash = hashValue(key);
		Bucket<K, V> p = table[hash];
		for (int i=0; i<size; i++) {
			if(p.status == Status.EMPTY || p.status == Status.DELETED ) {
				p.set(key, data, Status.OCCUPIED);
				return true;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return false;
	}
	
	// 키 값 key를 갖는 요소의 삭제
	public boolean remove(K key) {
		Bucket<K, V> p = searchNode(key);
		if(p == null)
			return false;
		
		p.setStatus(Status.DELETED);
		return true;
	}
	
	public void dump() {
		for(int i=0; i<size; i++) {
			System.out.printf("%02d ", i);
			switch(table[i].status) {
			case OCCUPIED : 
				System.out.printf("%s (%s) \n", table[i].getKey(), table[i].getValue());
				break;
			case DELETED:
				System.out.println("-- 삭제 --"); break;
			case EMPTY:
				System.out.println("-- 미등록 --"); break;
			}
		}
	}
	
}
