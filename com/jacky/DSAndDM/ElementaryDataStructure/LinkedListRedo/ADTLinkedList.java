package com.jacky.DSAndDM.ElementaryDataStructure.LinkedListRedo;

import java.util.Stack;

public class ADTLinkedList {
	public Node first;
	public int size;

	public ADTLinkedList() {
		first = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	// insert at front
	public void insert(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public void insert(int value, int index) {
		if (index > size()) {
			System.out.println("index out of bound");
			return;
		}
		Node node = new Node(value);
		Node temp = first;
		for (int i = 0; i < index - 1 && temp != null; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}

	public void insertEnd(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
			size++;
			return;
		} else {
			Node temp = first;
			while (temp.next != null) {
				temp = temp.next;
				if (temp.next == null) {
					temp.next = node;
					size++;
					return;
				}
			}
		}
	}

	public int sumLinkedList(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.value + sumLinkedList(node.next);
		}
	}

	public void traverse() {
		System.out.println("traversing the linked list");
		Node temp;
		for (temp = first; temp != null; temp = temp.next) {
			System.out.println(temp.value);
		}
	}

	public boolean contain(int value) {
		for (Node temp = first; temp != null; temp = temp.next) {
			if (temp.value == value) {
				return true;
			}
		}
		return false;
	}

	// remove front
	public void remove() {
		if (first == null) {
			System.out.println("linked list is empty");
			return;
		} else {
			first = first.next;
			size--;
		}
	}

	public void removeEnd() {
		if (first == null) {
			System.out.println("linked list is empty");
			return;
		}
		Node temp;
		for (temp = first; temp.next != null; temp = temp.next) {
			if (temp.next.next == null) {
				temp.next = null;
				size--; // NOTE: once we remove it, return the method
						// immediately to prevent null pointer exception for
						// next iteration
				return; // must return now to prevent null pointer exception
			}
		}
	}

	public void remove(int value) {
		if (first.value == value) {
			first = first.next;
			size--;
		}
		Node temp;
		for (temp = first; temp.next != null; temp = temp.next) {
			if (temp.next.value == value) {
				temp.next = temp.next.next;
				size--;
				return;
			}
		}
	}

	public void removeAtIndex(int index) {
		if (index > size()) {
			System.out.println("index out of bound");
			return;
		}
		if (index == 0) {
			first = first.next;
			size--;
			return;
		}
		Node temp = first;
		for (int i = 0; i < index - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		// System.out.println("temp = " + temp.value);
		temp.next = temp.next.next;
		size--;

	}

	public void reversePrint(Node node) {
		if (node == null) {
			return;
		}
		reversePrint(node.next);
		System.out.println(node.value);
	}

	public void traverseSkipEven(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		if (node.next == null) {
			return;
		} else {
			traverseSkipEven(node.next.next);
		}
	}

	// swap pairwise:
	// for example: 1 -> 2 -> 3 -> 4
	// should display: 2 -> 1 -> 4 -> 3
	public void pairwiseSwap(Node node) {
		if (size() == 0) {
			System.out.println("empty");
			return;
		}
		if (node.next == null) {
			System.out.println(node.value);
			return;
		}
		Node one = node;
		Node two = node.next;
		System.out.println(two.value);
		System.out.println(one.value);
		if (two.next == null)
			return;
		pairwiseSwap(two.next);
	}

	public void mergeLinkedList(ADTLinkedList l1, ADTLinkedList l2) {
		Node temp1 = l1.first; // get the current node
		Node temp2 = l2.first; // get the current node
		Node temp1Next; // is used to store the next node
		Node temp2Next; // is used to store the next node
		while (temp1 != null && temp2 != null) {
			// save the next pointer
			temp1Next = temp1.next;
			temp2Next = temp2.next;
			// make l2 current the next of l1 current
			temp2.next = temp1.next;
			temp1.next = temp2;
			// update current pointers for next iteration
			temp1 = temp1Next;
			temp2 = temp2Next;
		}
		// update head pointer of the second
		l2.first = temp2; // this will cause the 2nd list to be cut off
		l1.traverse();
		l2.traverse();
	}

	public void deleteNAfterM(ADTLinkedList l, int m, int n) {
		Node node = l.first;
		Node delete; // is used for node to be deleted
		while (node != null) {
			// skipping m nodes
			for (int i = 0; i < m - 1 && node != null; i++) {
				node = node.next;
			}
			// if at some point, a node is null, return
			if (node == null) {
				return;
			}
			// start from the next node and delete N nodes;
			delete = node.next;
			// this iteration is used to find the node next to last node to be
			// deleted
			// once we find that node, we can point the node from skip loop to
			// it
			for (int i = 0; i <= n - 1 && delete != null; i++) {
				//Node temp = delete;
				delete = delete.next;
			}
			node.next = delete; // point the next node to the node after delete
								// node
			node = delete; // change pointer for next iteration
		}
		l.traverse();
	}

	public void reverse(ADTLinkedList l) {
		System.out.println("reversing");
		if(l.size() <= 1){
			return;
		}
		Node nearNode = l.first;
		Node mid, far;
		mid = nearNode.next;
		far = mid.next;
		nearNode.next = null; //tricky here, to cut the reference from the first node, in order to create a new linked list
		while(far != null){
			mid.next = nearNode;
			nearNode = mid;
			mid = far;
			far = far.next;		
		}
		mid.next = nearNode;
		l.first = mid; //must use mid because at this point, far is null because it escape the white loop, duh
	}

	public static void main(String[] args) {
		ADTLinkedList l = new ADTLinkedList();
		l.insert(5);
		l.insert(3);
		l.insert(2);
		l.insert(1);
		l.insert(4, 3);
		l.insertEnd(6);
		l.insertEnd(7);
		l.insertEnd(8);
		//l.reverse(l);
		l.deleteNAfterM(l, 3, 2);
		//l.traverse();
		// l.deleteNAfterM(l, 2, 2);
		//l.reverse(l);
		//l.traverse();
		// l.removeAtIndex(1);
		// l.remove();
		// l.removeEnd();
		// l.remove(5);
		/*
		 * System.out.println("size: " + l.size()); l.traverse();
		 * System.out.println("contain 1: " + l.contain(1));
		 * System.out.println("contain 2: " + l.contain(2));
		 * System.out.println("contain 3: " + l.contain(3));
		 * System.out.println("contain 4: " + l.contain(4));
		 * System.out.println("contain 5: " + l.contain(5));
		 * System.out.println("reversing"); l.reverse(l.first);
		 * System.out.println("skip even"); l.traverseSkipEven(l.first); int sum
		 * = l.sumLinkedList(l.first); System.out.println("sum: " + sum);
		 * l.pairwiseSwap(l.first);
		 */

		ADTLinkedList l2 = new ADTLinkedList();
		l2.insert(10);
		l2.insert(11);
		l2.insert(12);
		l2.insert(13);
		// l.traverse();
		// l2.traverse();
		// l.mergeLinkedList(l, l2);
	}
}
