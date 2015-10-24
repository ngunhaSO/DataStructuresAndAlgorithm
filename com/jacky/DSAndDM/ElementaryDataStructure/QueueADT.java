package com.jacky.DSAndDM.ElementaryDataStructure;

public class QueueADT {
	private int[] storage;
	private int size;
	private int head;
	private int tail;
	
	public QueueADT() {
		storage = new int[10];
		size = 0;
		head = 0;
		tail = 0;
	}
	
	public QueueADT(int n){
		storage = new int[n];
		size = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public void enqueue(int value){
		if(tail == storage.length - 1){
			System.out.println("queue is full");
		}
		else {
			storage[tail] = value;
			tail++;
			size++;
		}
	}
	
	public int dequeue() {
		if(isEmpty()){
			System.out.println("queue empty, cannot dequeue");
			return -1;
		}
		else {
			int value = storage[head];
			head++;
			size--;
			return value;
		}
	}
	
	public int size(){
		return size;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = head; i < tail; i++){
			sb.append(storage[i] + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		QueueADT queue = new QueueADT();
		queue.enqueue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println("dequeue: " + queue.dequeue());
		//System.out.println("dequeue: " + queue.dequeue());
		System.out.println("print queue: " + queue.toString());
		System.out.println("size: " + queue.size());
	}
}	
