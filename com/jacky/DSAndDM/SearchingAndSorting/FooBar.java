package com.jacky.DSAndDM.SearchingAndSorting;

public class FooBar {
	public void printFooBar2(int n){
		for(int i = 0; i <= n; i++){
			if(i%15 == 0){
				System.out.println("foobar");
			}
			else if(i%3 == 0) {
				System.out.println("foo");
			}
			else if(i%5 == 0){
				System.out.println("Bar");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public void printFooBar(int n){
		int i1 = 1, i3 = 3, i5 = 5, i15 = 15;
		for(; i1 <= n; i1++){
			if(i1 != i3 && i1 != i5 && i1 != i15) {
				System.out.println(i1);
			}
			else {
				if(i1 == i3){
					System.out.println("foo");
					i3 += 3;
				}
				if(i1 == i5){
					System.out.println("bar");
					i5 += 5;
				}
				if(i1 == i15){
					System.out.println("foobar");
					i15 += 15;
				}
			}
		}
	}
	 
	public static void main(String[] args) {
		FooBar f = new FooBar();
		//f.printFooBar(30);
		f.printFooBar2(30);
	}
}
