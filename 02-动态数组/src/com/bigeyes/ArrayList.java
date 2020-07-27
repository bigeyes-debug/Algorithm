package com.bigeyes;

public class ArrayList {
	
	private int size;
	private int[] elements;
	private static final int DEFAULT_CAPACITY=10;
	private static final int ELEMENT_NOT_FOUND=-1;
	
	private void  outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:"+index+",Size:" + size);

	}
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			outOfBounds(index);
		}
	}
	private void rangeCheckForAdd(int index) {
		if(index<0||index>size) {
			outOfBounds(index);
		}
	}
	
	
	private void ensureCapacity(int capacity) {
		int oldCapacity=elements.length;
		if(oldCapacity >= capacity) {
			return ;
		}
		int newCapacity=oldCapacity+(oldCapacity>>1);
		int[] newElements=new int[newCapacity];
		for(int i=0;i<size;i++) {
			newElements[i]=elements[i];
		}
		elements = newElements;
	}
	public ArrayList(int capaticy) {
		capaticy=(capaticy<DEFAULT_CAPACITY)?DEFAULT_CAPACITY :capaticy;
		elements= new int[capaticy];
		
	}
	public ArrayList () {
//		elements= new  int[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
	
	public void clear() {
		size=0;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public boolean contains(int element) {
		return indexOf(element)!=ELEMENT_NOT_FOUND;
	}
	
	public int get(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:" + size);
		}
		return elements[index];
	}
	
	public int set(int index,int element) {
		rangeCheck(index);
		int old = elements[index];
		elements[index]=element;
		return old;
	}
	
	public void add(int element) {
		add(size,element);
 	}
	
	public void add(int index,int element) {
		rangeCheckForAdd(index);
		
		ensureCapacity(size+1);
		for(int i=size-1;i>=index;i--) {
			elements[i+1]=elements[i];
		}
		elements[index]=element;
		size++;
	}
	public int remove(int index) {
		rangeCheck(index);
		int old=elements[index];
		for(int i=index+1;i<=size-1;i++) {
			elements[i-1]=elements[i];
		}
		size--;
		return old;
	}
	
	public int indexOf(int element) {
		for(int i=0;i<size;i++) {
			if(elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(",[");
		
		for(int i=0;i<size;i++) {
			if(i!=0) {
				string.append(", ");
			}
			string.append(elements[i]);
//		
//			if(i!=size-1) {
//				string.append(", ");
//			}
		}
		string.append("]");
		
		return string.toString();
	}
}
