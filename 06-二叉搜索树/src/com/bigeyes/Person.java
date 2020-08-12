package com.bigeyes;


public class Person implements Comparable<Person> {
	int age;
	String name;
	public Person(int age) {
		super();
		this.age = age;
	}
	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}


	@Override
	public int compareTo(Person e) {
		// TODO Auto-generated method stub
//		if(this.age > e.age) {
//			return 1;
//		}
//		else  if(this.age==e.age){
//			return 0;
//		}
//		else {
//			return -1;
//		}
		return age-e.age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:"+name+" age:"+age;
	}
//	BinarySearchTree<Person> bst2 =new BinarySearchTree<Person>(new PersonComparator());
//	bst2.add(new Person(12));
//	bst2.add(new Person(15));
	
}
