package com.jacky.DSAndDM.SearchingAndSorting;

public class SearchAlgo {
	
	public boolean bs(int[] array, int x){
		int low = 0;
		int high = array.length - 1;
		while(low <= high){
			int mid = (low + high)/2;
			if(array[mid] == x){
				return true;
			}
			else if(array[mid] > x){
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return false;
	}
	
	public boolean bsRecursive(int[] array, int x){
		int low = 0;
		int high = array.length - 1;
		
		return false;
	}
	
	
	//array must be in ascending order
	public static void main(String[] args) {
		SearchAlgo bs = new SearchAlgo();
		int[] array = {1,2,3, 5,6};
		System.out.println(bs.bs(array, 111));
	}
}
