package com.bigeyes;

import java.util.*;

import com.bigeyes.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public static interface Visitor<E>{
		void  visit(E element);
	}
	public BinarySearchTree() {
		this(null);
	}
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator =comparator;
		
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		 if(root ==null) {
			 root=new Node<>(element,null);
			 size++;
			 return;
		 }
		 int cmp=0;
		 Node<E> node=root;
		 Node<E> parent=null;
		 while(node!=null) {
			 parent=node;
			 cmp=compare(element,node.element);
			 if(cmp>0) {
				 node=node.right;
			 }else if(cmp<0) {
				 node=node.left;
			 }else {
				 node.element=element;
				 return;
			 }
		 }
		Node<E> newNode =new Node<>(element,parent);
		if(cmp>0) {
			parent.right=newNode;
		}else {
			parent.left=newNode;
		}
				 
		 
	}
	
	public void remove() {
		
	}
	
	public boolean contains(E element) {
		return false;
	}
	
	
	public void preorderTraversal(Visitor <E> visitor) {
		preorderTraversal(root,visitor);
	}
	public void preorderTraversal(Node<E> node,Visitor <E> visitor) {
		
		if(node ==null||visitor==null) return ;
		visitor.visit(node.element);
		preorderTraversal(node.left,visitor);
		preorderTraversal(node.right,visitor);
		
	}
	
//	public void inorderTraversal() {
//		inorderTraversal(root);
//	}
//	public void inorderTraversal(Node<E> node) {
//		
//		if(node ==null) return ;
//		
//		inorderTraversal(node.left);
//		System.out.println(node.element);
//		inorderTraversal(node.right);
//		
//	}
	
	
	public void inorderTraversal(Visitor <E> visitor) {
		inorderTraversal(root,visitor);
	}
	public void inorderTraversal(Node<E> node,Visitor <E> visitor) {
		
		if(node ==null||visitor==null) return ;
		inorderTraversal(node.left,visitor);
		visitor.visit(node.element);

		inorderTraversal(node.right,visitor);
		
	}
	public void postorderTraversal(Visitor <E> visitor) {
		postorderTraversal(root,visitor);
	}
	public void postorderTraversal(Node<E> node,Visitor <E> visitor) {
		
		if(node ==null||visitor==null) return ;
		postorderTraversal(node.left,visitor);
		postorderTraversal(node.right,visitor);
		visitor.visit(node.element);
		
	}
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	public void postorderTraversal(Node<E> node) {
		
		if(node ==null) return ;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.element);

		
	}
	
	public void levelOrderTransal() {
		if(root ==null) return ;
		
		Queue<Node<E>> queue=new LinkedList<>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node<E> node=queue.poll();
			System.out.println(node.element);
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
		}
	}
	
	public void levelOrderTransal(Visitor<E> visitor) {
		if(root ==null||visitor==null) return ;
		
		Queue<Node<E>> queue=new LinkedList<>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node<E> node=queue.poll();
			visitor.visit(node.element);
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
		}
	}
	
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalAccessError("element must not be null");
		}
	}
	
	private int compare(E e1,E e2) {
		if(comparator!=null) {
			return comparator.compare(e1, e2);
		}
			return((Comparable<E>)e1).compareTo(e2);
	}
	private static class Node<E>{
		E element;
		Node<E> left;
		Node <E> right;
		Node <E> parent;
		public Node(E element,Node<E> parent) {
			this.element=element;
			this.parent=parent;
		}
	}
	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}
	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}
	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).right;
	}
	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		Node <E> myNode = (Node<E>) node;
		String parentString=null;
		if(myNode.parent!=null) {
			parentString =myNode.parent.element.toString();
		}
		return ((Node<E>)node).element +"p("+parentString+")";
	}
}
