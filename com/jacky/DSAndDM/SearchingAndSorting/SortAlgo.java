package com.jacky.DSAndDM.SearchingAndSorting;

import org.omg.IOP.IOR;

public class SortAlgo {
	
	public void selectionSort(int[] array){
		for(int i = 0; i < array.length; i++){
			int min = array[i];
			int index = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < min){
					min = array[j];
					index = j;
				}
			}
			if(index != i){
				array[index] = array[i];
				array[i] = min;
			}
		}
	}
	
	public void insertionSort(int[] array){
		for(int i = 1; i < array.length; i++){
			int current = array[i];
			int j;
			for(j = i - 1; j >= 0 && array[j] > current; j--){
				array[j+1] = array[j];
			}
			array[j+1] = current;
		}
		
	}
	
	
	public void bubbleSort(int[] array){	
		for(int i = array.length - 1; i >=0; i--){
			for(int j = 1; j <= i; j++){
				if(array[j - 1] > array[j]){
					//swap elements at j-1 and j
					int temp = array[j - 1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	
	public void mergeSort(int [] list) {
		 if(list.length == 1){
			 return;
		 }
		 
		 int[] first = new int[list.length/2];
		 int[] second = new int[list.length - first.length];
		 
		 //copying array over
		 System.arraycopy(list, 0, first, 0, first.length);
		 System.arraycopy(list, first.length, second, 0, second.length);
		 
		 mergeSort(first);
		 mergeSort(second);
		 merge(first, second, list);
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
    	int iFirst = 0;
    	int iSecond = 0;
    	int iOriginal = 0;
    	while(iFirst < first.length && iSecond < second.length){
    		if(first[iFirst] < second[iSecond]){
    			result[iOriginal] = first[iFirst];
    			iFirst++;
    		}
    		else {
    			result[iOriginal] = second[iSecond];
    			iSecond++;
    		}
    		iOriginal++;
    	}
    	//copy what left
    	System.arraycopy(first, iFirst, result, iOriginal, first.length - iFirst);
    	System.arraycopy(second, iSecond, result, iOriginal, second.length - iSecond);
    }
    
    public void quickSort(int[] array){
    	quickSort(array, 0, array.length - 1);
    }
    
	private void quickSort(int[] array, int low, int high) {
		if(low >= high){
			return;
		}
		//sort the pivot in its correct order
		int pivot = array[low];
		int i = low - 1;
		int j = high + 1;
		while(i < j){
			i++;
			while(array[i] < pivot){
				i++;
			}
			j--;
			while(array[j] > pivot) {
				j--;
			}
			
			if(i < j){
				swap(array, i, j);
			}
		}
		//recursively sort left and right sub array
		quickSort(array, low, j);
		quickSort(array, j+1, high);
		
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		SortAlgo s = new SortAlgo();
		System.out.println("selection sort:");
		int[] array1 = {3,2,1,5,7,9};	
		s.selectionSort(array1);
		for(int i = 0; i < array1.length; i++){
			System.out.println(array1[i]);
		}
		System.out.println("insertion sort");
		int[] array2 = {9,2,1,0,10};
		s.insertionSort(array2);	
		for(int i = 0; i < array2.length; i++){
			System.out.println(array2[i]);
		}
		System.out.println("merge sort");
		int[] array3 = {1,4,3,2,0};
		s.mergeSort(array3);
		for(int i = 0; i < array3.length; i++){
			System.out.println(array3[i]);
		}
		System.out.println("quick sort");
		int[] array4 = {5,4,3,2,3,5,2,1,1};
		s.quickSort(array4);
		for(int i = 0; i < array4.length; i++){
			System.out.println(array4[i]);
		}
		
		System.out.println("bubble sort");
		int[] array5 = {3,2,0,1,4};
		s.quickSort(array5);
		for(int i = 0; i < array5.length; i++){
			System.out.println(array5[i]);
		}
	}
}