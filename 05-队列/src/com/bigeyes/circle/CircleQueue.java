package com.bigeyes.circle;

import com.bigeyes.list.LinkedList;
import com.bigeyes.list.List;
public class CircleQueue<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY=10;
	public CircleQueue() {
		elements = (E[])new Object[DEFAULT_CAPACITY];
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	private int index(int index) {
		return (front +index)%elements.length;
	}
	private void ensureCapacity(int capacity) {
		int oldCapacity=elements.length;
		if(oldCapacity >= capacity) {
			return ;
		}
		int newCapacity=oldCapacity+(oldCapacity>>1);
		E[] newElements=(E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newElements[i]=elements[index(i)];
		}
		elements = newElements;
		
		front=0;
	}
	public void enQueue(E element) {
		ensureCapacity(size+1);
		elements[index(size)]=element;
		size++;
	}
	
	public E deQueue() {
		E frontElement =elements[front];
		elements[front]=null;
		front=index(1);
		size--;
		return frontElement;
	}
	
	public E front() {
		return elements[front];
	}
	
	public void clear() {
	
		for(int i=0;i<size;i++) {
			elements[index(i)]=null;
		}
		size=0;
		front=0;
//		list.clear();
	}
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capacity=").append(elements.length)
		.append("size=").append(size)
		.append("front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
