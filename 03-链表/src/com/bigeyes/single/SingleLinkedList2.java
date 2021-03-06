package com.bigeyes.single;

import com.bigeyes.AbstractList;

/**
 * 虚拟头结点
 * @author admin
 *
 * @param <E>
 */
public class SingleLinkedList2<E>  extends AbstractList<E>{
	private Node<E> first;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
	}
	public  SingleLinkedList2() {
		// TODO Auto-generated constructor stub
		first=new Node <>(null,null);
	}
	@Override
	public void clear() {
		size=0;
		first=null;
		// TODO Auto-generated method stub
		
	}



	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node <E> node=node(index);
		E old=node.element;
		node.element=(E) element;
		return old;
		// TODO Auto-generated method stub
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		Node <E>prev=index==0?first:node(index-1);
		prev.next=new Node<>(element, prev.next);
		
		// TODO Auto-generated method stub
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		// TODO Auto-generated method stub
		Node <E>prev=index==0?first:node(index-1);
		Node <E> node =prev.next;
		prev.next=prev.next.next;
		
		size--;
		return node.element;
	
	}

	@Override
	public int indexOf(E element) {
		if(element == null) {
			Node <E> node= first;
			for(int i=0;i<size;i++) {
				if(node.element==null) {
					return i;
				}
				node=node.next;
			}
			
		}else {
			Node <E> node= first;

			for(int i=0;i<size;i++) {
				if(element.equals(node.element)) {
					return i;
				}
				node=node.next;

			}
		}
	
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index){
		rangeCheck(index);
		Node<E> node=first.next;
		for(int i=0;i<index;i++) {
			node=node.next;
		}
		return node;
	}

	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(",[");
		Node<E> node=first.next;
		for(int i=0;i<size;i++) {
			if(i!=0) {
				string.append(", ");
			}
			string.append(node.element);
			node=node.next;

		}
		string.append("]");
		
		return string.toString();
	}
}
