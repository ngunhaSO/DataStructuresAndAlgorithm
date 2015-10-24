package com.jacky.DSAndDM.ElementaryDataStructure.PriorityQueue;
//VERY ACCURATE
import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
	
	private List list;
	
	public PriorityQueue() {
		list = new ArrayList(32);
	}
	
	public int parent(int i){	
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2 * i + 1;
	}
	
	public int right(int i){
		return 2*i + 2;
	}
	
	public void push(int value){
		list.add(value);
		pushUp(list.size() - 1);
	}

	private void pushUp(int i) {
		while(i > 0 && !isGreaterOrEqual(parent(i), i)) {
			swap(parent(i),i);
			i = parent(i); //reduce to base case
		}
	}
	
	public Object pop(){
		if(list.size() > 0){
			swap(0, list.size()-1);
			Object result = list.remove(list.size() - 1);
			pushDown(0);
			return result;
		}
		else {
			return null;
		}
	}

	private void pushDown(int i) {
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left < list.size() && !isGreaterOrEqual(largest, left)){
			largest = left;
		}
		if(right < list.size() && !isGreaterOrEqual(largest, right)){
			largest = right;
		}
		if(largest != i){
			swap(largest, i);
			pushDown(largest);
		}
	}

	private void swap(int i, int j) {
		Object temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	private boolean isGreaterOrEqual(int parent, int i) {
		if(((Integer)list.get(parent)).intValue() >= ((Integer)list.get(i)).intValue()){
			return true;
		}
		return false;
	}
	
	public int size(){
		return list.size();
	}
	
	public String toString() {
        StringBuffer s = new StringBuffer("Heap:\n");
        int rowStart = 0;
        int rowSize = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i == rowStart+rowSize) {
                s.append('\n');
                rowStart = i;
                rowSize *= 2;
            }
            s.append(list.get(i));
            s.append(" ");
        }
        return s.toString();
    }
	
	public static void main(String[] args) {
		PriorityQueue p = new PriorityQueue();
		p.push(1);
		p.push(2);
		p.push(5);
		p.push(0);
		p.push(9);
		System.out.println(p+"\n");
		//System.out.println("size: " + p.size());
	}
	
}
