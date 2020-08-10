package com.bigeyes.circle;

public class CircleDeque <E>{
	private int front;
	
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY=10;
	
	public CircleDeque() {
		elements = (E[])new Object[DEFAULT_CAPACITY];
	}
	public int size() {
		return size;
	}
	
	private int index(int index) {
		return (front +index+elements.length)%elements.length;
	}
	private void ensureCapacity(int capacity) {
		int oldCapacity=elements.length;
//		System.out.println(capacity);

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
	public boolean isEmpty() {
		return size==0;
	}
	
	
	public void enQueueRear(E element) {
		ensureCapacity(size+1);
		elements[index(size)]=element;
		size++;
	}
	
	public E deQueueFront() {
		
		E frontElement =elements[front];
		elements[front]=null;
		front=index(1);
		size--;
		return frontElement;	
		}
	
	public void enQueueFront(E element) {
		ensureCapacity(size+1);
		front=index(-1);
		elements[front]=element;
		size++;
 	}
	
	public E deQueueRear() {
		int rearIndex=index(size-1);
		E rear=elements[rearIndex];
		elements[rearIndex]=null;
		size--;
		return rear;
	}
	
	public E front() {
		return elements[front];
	}
	
	public E rear() {
		return elements[index(size-1)];

	}
	public void clear() {
		size=0;
		front=0;
		for(int i=0;i<elements.length;i++) {
			elements[i]=null;
		}
	}
	
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
