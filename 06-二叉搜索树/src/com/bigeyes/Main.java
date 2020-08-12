package com.bigeyes;

import java.util.*;

import com.bigeyes.BinarySearchTree.Visitor;
import com.bigeyes.printer.BinaryTrees;
import com.bigeyes.printer.BinaryTrees.PrintStyle;
public class Main {
	
	private static class PersonComparator implements Comparator<Person>{

		@Override
		public int compare(Person e1, Person e2) {
			// TODO Auto-generated method stub
			return e1.getAge() -e2.getAge();
		}
		
	}
	static void test1() {
		Integer data[] =new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
			BinarySearchTree<Integer>  bst=new BinarySearchTree<Integer>();
			for(int i=0;i<data.length;i++) {
				bst.add(data[i]);
			}
			BinaryTrees.println(bst);
//			bst.inorderTraversal();

	}
	static void test2() {
		Integer data[] =new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
			BinarySearchTree<Person>  bst=new BinarySearchTree<>();
			for(int i=0;i<data.length;i++) {
				bst.add(new Person(data[i]));
			}
			BinaryTrees.println(bst);
	}
	
	static void test3() {
		Integer data[] =new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
			BinarySearchTree<Person>  bst=new BinarySearchTree<>(new Comparator<Person>() {

		
				@Override
				public int compare(Person p1, Person p2) {
					// TODO Auto-generated method stub
					return p2.getAge()-p1.getAge();
				}
			});
			for(int i=0;i<data.length;i++) {
				bst.add(new Person(data[i]));
			}
			BinaryTrees.println(bst);
	}
	static void test4() {
		BinarySearchTree<Person>  bst=new BinarySearchTree<>();
		bst.add(new Person(10,"rose"));
		bst.add(new Person(12,"jack"));
		bst.add(new Person(6,"jim"));
		bst.add(new Person(10,"michale"));
		BinaryTrees.println(bst);

	}
	static void test5() {
		Integer data[] =new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
			BinarySearchTree<Integer>  bst=new BinarySearchTree<Integer>();
			for(int i=0;i<data.length;i++) {
				bst.add(data[i]);
			}
			BinaryTrees.println(bst);
			bst.inorderTraversal(new Visitor<Integer>() {
				@Override
				public void visit(Integer element) {
					// TODO Auto-generated method stub
					System.out.print("_"+element+"_");
					
				}
				
			}); 

	}

	public static void main(String[] args) {
		test5();
//		BinarySearchTree<Person> bst2 =new BinarySearchTree<Person>(new PersonComparator());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
	}
}
