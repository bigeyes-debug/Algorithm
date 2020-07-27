package com.bigeyes;

public class Main {
	
	public static void main(String args[]) {
		ArrayList list= new ArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(0,100);
		list.set(3,80);
//		list.remove(2);
//		list.remove(list.size()-1);
		System.out.println(list);
	}
}
