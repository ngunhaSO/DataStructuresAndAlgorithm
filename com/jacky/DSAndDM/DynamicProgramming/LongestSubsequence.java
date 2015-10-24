package com.jacky.DSAndDM.DynamicProgramming;

public class LongestSubsequence {
	/*
	 * We neeed:
	 * 1. size array to keep track of longest LIS endiing with current position
	 */
	public void findLongestSubsequence(int[] array){
		String[] paths  = new String[array.length]; //array to track the path to print out
		int[] sizes = new int[array.length]; //size array to keep track of longest LIS ending
		
		//first we assign initial values to each path/size, by setting size to 1
		// and path equals the value
		for(int i = 0; i < array.length; i++){
			sizes[i] = 1;
			paths[i] = array[i] + " ";
		}
		
		//before we start the loop, we define the support var to keep track
		int maxLength = 0;
		
		for(int i = 1; i < array.length; i++){//we start at 1 so we can check the right side with left side for smaller one
			for(int j = 0; j < i; j++){ //inner loop to check previous items
				if(array[i] > array[j] && sizes[i] < sizes[j] + 1){
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + array[i] + " ";
					//update max length i neccessary
					if(maxLength < sizes[i]){
						maxLength = sizes[i];
					}
				}
			}
		}
		
		for(int i = 0; i < paths.length; i++){
			if(sizes[i] == maxLength)
				System.out.println(paths[i] + " max length: " + maxLength);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3,2,6,1,8};
		LongestSubsequence ls = new LongestSubsequence();
		ls.findLongestSubsequence(array);
	}
}
