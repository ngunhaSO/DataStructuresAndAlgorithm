package com.jacky.DSAndDM.ElementaryDataStructure;

public class ListNode {
	// Constructors
	public ListNode(Object theElement) {
		this(theElement, null);
	}

	public ListNode(Object theElement, ListNode n) {
		element = theElement;
		next = n;
	}

	public Object element;
	public ListNode next;
}
