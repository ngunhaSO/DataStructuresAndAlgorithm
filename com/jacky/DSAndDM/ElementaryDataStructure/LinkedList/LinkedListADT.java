package com.jacky.DSAndDM.ElementaryDataStructure.LinkedList;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class LinkedListADT {
	public Node first;
	private int size;
	
	public LinkedListADT(){
		size = 0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return size;
	}
	
	public void insert(int value) {
		
		Node newNode = new Node(value);
		if(first == null){
			first = newNode;
			size++;
			return;
		}
		newNode.next = first;
		first = newNode;
		size++;
	}
	
	public void insert(int value, int index){
		Node newNode = new Node(value);
		if(size < index){
			System.out.println("index exceeded");
			return;
		}
		else if(size == index){
			insertEnd(value);
			return;
		}
		Node temp = first;
		for(int i = 0; temp.next !=null && i < index - 1; temp = temp.next){
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		size++;		
		
	}
	
	public void insertEnd(int value){
		Node newNode = new Node(value);
		if(first == null){
			first = newNode;
			size++;
		}
		else {
			Node temp;
			for(temp = first; temp !=null; temp = temp.next){
				if(temp.next == null){
					temp.next = newNode;
					size++;
					return;
				}
			}
		}
	}
	
	public boolean search(int value){
		Node node = new Node(value);
		Node temp;
		for(temp = first; temp != null; temp = temp.next){
			if(temp.value == value){
				return true;
			}
		}
		return false;
	}
	
	//a special case, a value need to remove is at the first node, do it
	//otherwise, check the temp.next.value to value to be searched!!!!
	public void remove(int value){
		if(first.value == value){
			first = first.next;
			size--;
			return;
		}
		Node temp = first;
		for(temp = first; temp.next != null; temp =temp.next){
			if(temp.next.value == value){
				temp.next = temp.next.next;
				size--;
				return;
			}	
		}
	}
	
	public void remove(){
		first = first.next;
		size--;
	}
	
	public void reverseLinkedList(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(node != null){
			stack.add(node);
			node = node.next;
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop().value);
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Node temp = first; temp != null; temp = temp.next){
			sb.append(temp.value + " ");
		}
		return sb.toString();
	}
	
	public void printReverse(Node first){
		if(first == null){
			return;
		}
		printReverse(first.next);
		System.out.println(first.value + " ");
	}
	
	public void skipEvenNode(Node first){
		if(first == null){
			return;
		}
		System.out.println(first.value);
		if(first.next != null){
			skipEvenNode(first.next.next);
		}
		System.out.println(first.value);
	}
	
	public int sumLinkedList(Node node){
		if(node.next == null){
			return node.value;
		}
		else {
			return node.value + sumLinkedList(node.next);
		}
	}
	
	public boolean isLinkedListAsc(Node node){
		if(node.next != null && node.next.value < node.value){
			return false;
		}
		else {
			node = node.next;
			if(node == null){
				return true;
			}
			else {
				return isLinkedListAsc(node);
			}
		}
	}
	
	public static void findIntersection(LinkedListADT l1, LinkedListADT l2){
		HashSet<Node> hs = new HashSet<Node>();
		HashSet<Node> result = new HashSet<Node>();
		Node current1 = l1.first;
		while(current1 != null){
			hs.add(current1);
			current1 = current1.next;
		}
		Node current2 = l2.first;
		while(current2 != null){
			if(hs.contains(current2)){
				result.add(current2);
			}
			current2 = current2.next;
		}
		for(Node n : result){
			System.out.println(n.value);
		}
	}
	
	public Node findFirstRepeat(LinkedListADT l){
		Hashtable<Node, Integer> hash = new Hashtable<Node, Integer>();
		Node temp = l.first;
		while(temp != null){
			if(!hash.containsKey(temp)){
				hash.put(temp, new Integer(1));
			}
			else {
				hash.put(temp, (Integer)(hash.get(temp)) + 1);
			}
		}
		
		//loop thru the hash, if a key has a value of 2, return that node immediately	
		return null;
	}
	
	public static void main(String[] args) {
		LinkedListADT ll = new LinkedListADT();
		ll.insert(5);
		ll.insert(4);
		ll.insert(3);
		ll.insert(1);
		/*ll.insert(1);
		ll.insert(2);
		ll.insertEnd(3);
		ll.insert(4,1);
		ll.insert(5,4);*/
		//ll.remove(3);
		//ll.remove();
		/*System.out.println("found 3: " + ll.search(3));
		System.out.println("size: " + ll.size());
		System.out.println(ll.toString());
		System.out.println("is mylist asc: " + ll.isLinkedListAsc(ll.first));
		System.out.println("sum linkedlist: " + ll.sumLinkedList(ll.first));*/
		//ll.printReverse(ll.first);
		//ll.skipEvenNode(ll.first);
		
		LinkedListADT ll2 = new LinkedListADT();
		ll2.insert(55);
		ll2.insert(4);
		ll2.insert(3);
		ll2.insert(11);
		
		//findIntersection(ll, ll2);
		ll.reverseLinkedList(ll.first);
	}
}
