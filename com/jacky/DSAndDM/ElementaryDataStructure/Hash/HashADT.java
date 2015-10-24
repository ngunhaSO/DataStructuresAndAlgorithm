package com.jacky.DSAndDM.ElementaryDataStructure.Hash;

import java.util.LinkedList;
import java.util.List;

public class HashADT<AnyType> {
	
	private static final int DEFAULT_SIZE = 101;
	private List<AnyType>[] theList;
	private int size;
	
	public HashADT() {
		this(DEFAULT_SIZE);
	}
	
	public HashADT(int size) {
		theList = new LinkedList[nextPrime(size)]; //create custom size
		for(int i = 0; i < theList.length; i++){ //loop thru the new size
			theList[i] = new LinkedList<AnyType>(); //assign a linkedlist for each index
		}
	}
	
	private static int nextPrime(int n){
		return 3;
	}
	
	public void insert(AnyType value){
		List<AnyType> whichList = theList[myhash(value)];
		if(!whichList.contains(value)){
			whichList.add(value);
			if(size++ > theList.length){
				rehash();
			}
			
		}
	}
	
	public boolean search(AnyType value){
		List<AnyType> whichList = theList[myhash(value)];
		return whichList.contains(value);
	}
	
	private void rehash() {
		
	}

	private int myhash(AnyType x){
		int hashValue = x.hashCode();
		hashValue %= theList.length; //hashvalue = key mod tablesize
		if(hashValue < 0){
			hashValue += theList.length;
		}
		return hashValue;
	}
	
	public static void main(String[] args) {
		HashADT<Integer> hash = new HashADT<Integer>();
		hash.insert(2);
		hash.insert(3);
		System.out.println("contain 4? " + hash.search(4));
	}
}
