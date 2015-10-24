package com.jacky.DSAndDM.ElementaryDataStructure;

public class StackADT {

	private int[] storage;
	private int size;
	private int top = 0;

	public StackADT() {
		storage = new int[3];
		size = 0;
	}

	public StackADT(int n) {
		storage = new int[n];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int value) {
		if(top == storage.length - 1){
			System.out.println("stack is full");
		}
		else {
			storage[top] = value;
			top++; //increase top by 1 for next insert
		}	
		size++;
		
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("stack empty, cannot pop");
			return -1;
		}
		else{
			int value = storage[top - 1];
			top--; //reduce top by 1 for next pop
			size--;
			return value;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < top; i++){
			sb.append(storage[i] + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		StackADT stack = new StackADT(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		int myvalue = stack.pop();
		System.out.println("pop out: " + myvalue);
		System.out.println("stack size: " + stack.size);
		System.out.println("print stack: " + stack.toString());
	}
}
