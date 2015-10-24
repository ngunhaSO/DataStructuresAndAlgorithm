package com.jacky.DSAndDM.ElementaryDataStructure.LinkedList;

public class Node {
	public int value;
	public Node next;
	
	public Node(int value){
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		
		if(!(obj instanceof Node)){
			return false;
		}
		
		Node n = (Node)obj;
		return Integer.compare(value, n.value) == 0;
	}
}
