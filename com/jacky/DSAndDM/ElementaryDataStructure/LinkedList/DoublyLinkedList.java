package com.jacky.DSAndDM.ElementaryDataStructure.LinkedList;
//this is more accurate than DoublyLinkedListADT.java
public class DoublyLinkedList {
	private Link first;
	private Link last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first ==null;
	}
	
	public void insert(int data){
		Link link = new Link(data);
		if(first == null){
			last = link; //hold reference of the last node right here
		}
		else {
			first.previous = link;
		}
		link.next = first;
		first = link;
	}
	
	public void insertLast(int data){
		Link link = new Link(data);
		if(first ==null){
			last = link; //hold tail node right here
		}
		else {
			last.next = link;
			link.previous = last;
		}
		last = link;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		if(first.next == null){ //check if the next item next to the first one is null, if so that means we only have 1 item in the list, just remove the last one
			last = null; //only 1 item in the list, remove the tail node reference.
		}
		else {
			first.next.previous = null; //otherwise just remove item from the front
		}	
		first = first.next;
		return temp;
	}
	
	public Link deleteLast() {
		Link temp = last;
		if(first.next == null){
			last = null;
		}
		else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	public void display(){
		Link current = first;
		System.out.println("printing forward...");
		while(current != null){
			System.out.println(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insert(1);
		dl.insert(2);
		dl.insert(3);
		System.out.println("before delete anything");
		dl.display();
		System.out.println("after delete anything");
		System.out.println("delete last: " + dl.deleteLast().data);
		System.out.println("delete first: " + dl.deleteFirst().data);
		dl.insertLast(1);
		dl.display();
	}
}
