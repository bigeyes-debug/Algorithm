package com.bigeyes.list;

public class ArrayList<E> extends AbstractList<E> {
	
	private E[] elements;
	private static final int DEFAULT_CAPACITY=10;
	private static final int ELEMENT_NOT_FOUND=-1;
	
	private void ensureCapacity(int capacity) {
		int oldCapacity=elements.length;
		if(oldCapacity >= capacity) {
			return ;
		}
		int newCapacity=oldCapacity+(oldCapacity>>1);
		E[] newElements=(E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newElements[i]=elements[i];
		}
		elements = newElements;
	}
	public ArrayList(int capaticy) {
		capaticy=(capaticy<DEFAULT_CAPACITY)?DEFAULT_CAPACITY :capaticy;
		elements= (E[])new Object[capaticy];
		
	}
	public ArrayList () {
//		elements= new  int[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
	
	public void clear() {
		for(int i=0;i<size;i++) {
			elements[i]=null;
		}
		size=0;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public boolean contains(E element) {
		return indexOf(element)!=ELEMENT_NOT_FOUND;
	}
	
	public E get(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:" + size);
		}
		return elements[index];
	}
	
	public E set(int index,E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index]=element;
		return old;
	}
	
	public void add(E element) {
		add(size,element);
 	}
	
	public void add(int index,E element) {
		rangeCheckForAdd(index);
		
		ensureCapacity(size+1);
		for(int i=size;i>index;i--) {
			elements[i]=elements[i-1];
		}
		elements[index]=element;
		size++;
	}
	public E remove(int index) {
		rangeCheck(index);
		E old=elements[index];
		for(int i=index+1;i<size;i++) {
			elements[i-1]=elements[i];
		}
		//一定要先减再清空
		elements[--size]=null;
		
		return old;
	}
	
	public E remove(E element) {
		return remove(indexOf(element));
	}
	
	public int indexOf(E element) {
		if(element == null) {
			for(int i=0;i<size;i++) {
				if(elements[i]==null) {
					return i;
				}
			}
		}else {
			for(int i=0;i<size;i++) {
				if(element.equals(elements[i])) {
					return i;
				}
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
