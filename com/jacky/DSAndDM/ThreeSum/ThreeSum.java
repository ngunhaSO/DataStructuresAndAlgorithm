package com.jacky.DSAndDM.ThreeSum;
/*
 * Three Sum problem:
 * Given an integer x and an unsorted array of integers, 
 * describe an algorithm to determine whether three of the numbers add up to 0. The algorithm must have O(n^2)
 * 
 * Before we can use the solution below, we must sort the array which gives us a penalty of O(nLogn)
 * Solution:
 * for (i in 1..n-2) {
		j = i+1  // Start right after i.
		k = n    // Start at the end of the array.
		
		while (k >= j) {
		    // We got a match! All done.
		    if (A[i] + A[j] + A[k] == 0) return (A[i], A[j], A[k])
		
		    // We didn't match. Let's try to get a little closer:
		    //   If the sum was too big, decrement k.
		    //   If the sum was too small, increment j.
		    (A[i] + A[j] + A[k] > 0) ? k-- : j++
		}
		// When the while-loop finishes, j and k have passed each other and there's
		// no more useful combinations that we can try with this i.
	}
 */
public class ThreeSum {
	
	private int[] numbers;
	
	public ThreeSum() {
		
	}
	
	public ThreeSum(int totalNumber) {
		numbers = new int[totalNumber];
	}
	
	public void threeSum(int[] numbers) {
		int j, k;
		int count = 0;
		for(int i = 0; i < numbers.length; i++) {
			j = i + i;
			k = numbers.length - 1;
			while(k >= j) {
				if(numbers[i] + numbers[j] + numbers[k] == 0){
					System.out.println(numbers[i] + "-" + numbers[j] + "-" + numbers[k]);
					count++;
					System.out.println("count: " + count);
				}
				
				//if not match
				if((numbers[i] + numbers[j] + numbers[k]) > 0) {
					k--;
				}
				else{
					j++;
				}
			}
		}
	}
	
	public void showResult() {
		int[] numbers = {1,1,2,-3,5,6}; //assuming the array is sorted with mergesort (nlogn)
		this.threeSum(numbers);
	}
	
}
