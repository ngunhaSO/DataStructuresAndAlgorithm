package com.jacky.DSAndDM.ElementaryDataStructure;
//A Queue using LinkedList

public class ListQueue implements Queue {

	public ListQueue() {
		front = back = null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void enqueue(Object x) {
		if (isEmpty()) // Make queue of one element
			back = front = new ListNode(x); //need to assign back = front so front can have refernce to back
		else {
			// Regular case
			back.next = new ListNode(x); //add new node to the back, set back.next. because we set front=back above, so at this point, fron also has .next point to new Node
			back = back.next; //update the back point to the new one
		}
	}

	public Object dequeue() {
		if (isEmpty())
			throw new UnderflowException("ListQueue dequeue");
		Object returnValue = front.element;
		front = front.next;
		return returnValue;
	}

	public Object getFront() {
		if (isEmpty())
			throw new UnderflowException("ListQueue getFront");
		return front.element;
	}

	public void makeEmpty() {
		front = null;
		back = null;
	}
	
	public void display() {
		ListNode temp = front;
		while(temp != null){
			System.out.println(temp.element + " ");
			temp = temp.next;
		}
	}
	
	private ListNode front;
	private ListNode back;
	
	public static void main(String[] args) {
		ListQueue lq = new ListQueue();
		lq.enqueue(1);
		lq.enqueue(2);
		lq.enqueue(3);
		/*int a = (Integer) lq.dequeue();
		a = (Integer)lq.dequeue();
		System.out.println(a);*/
		lq.display();

	}
}
