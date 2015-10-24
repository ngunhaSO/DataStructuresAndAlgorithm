package com.jacky.DSAndDM.AlgorithmIntegersMatrices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPrimeFactorization {
	
	private int number;
	private List<Integer> primeFactorList;
	
	public FindPrimeFactorization() {
		primeFactorList = new ArrayList<Integer>();
	}
	
	public FindPrimeFactorization(int number) {
		this.number = number;
		primeFactorList = new ArrayList<Integer>();
	}
	
	
	private boolean isPrime(int number) {
		if(number == 2) //2 is the oddest prime number
			return true;
		if(number % 2 ==0)
			return false;
		//only check for odd number
		for(int i = 3; i <= (int) Math.sqrt(number); i+=2){
			if(number % i == 0)
				return false;
		}
		return true;
	}
	
	private List<Integer> findPrimeFactor(int number) {
		//if number is a prime, then its prime factor will be found 
		//		in the range of 0-square root of number
		int primeUpperBound = (int) Math.sqrt(number); 	
		//hold a temp of original number so we can manipulate it
		int tempNumber = number; 	
		for(int i=2; i < primeUpperBound; i++) {
			if(isPrime(i) && (tempNumber % i == 0)) {
				int successiveQuotient = tempNumber / i;
				tempNumber = successiveQuotient; //
				primeFactorList.add(i);
				i--;	
			}
		}	
		return primeFactorList;
	}
	
	//check for a very long number
	private List<Integer> findLongPrimeFactor(long number) {
		//if number is a prime, then its prime factor will be found 
		//		in the range of 0-square root of number
		int tempPrime = (int) Math.sqrt(number); 	
		//hold a temp of original number so we can manipulate it
		long tempNumber = number; 	
		for(int i=2; i < tempPrime; i++) {
			if(isPrime(i) && (tempNumber % i == 0)) {
				long successiveQuotient = tempNumber / i;
				tempNumber = successiveQuotient; //
				primeFactorList.add(i);
				i--;	
			}
		}	
		return primeFactorList;
	}
	
	private void showResult() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("	Find the prime factorization");
		System.out.println("-----------------------------\n");
		System.out.println("Enter number you want to find prime factorization:");
		int number = scan.nextInt();
		primeFactorList = findPrimeFactor(number);
		for(int i = 0; i < primeFactorList.size(); i++) {
			System.out.println("Prime factor of " + number + " is: " + primeFactorList.get(i));
		}
	}
	
	//for testing very long number
	public void showLongResult() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("	Find the prime factorization");
		System.out.println("--------------------------------------------\n");
		System.out.println("Enter number you want to find prime factorization:");
		long number = scan.nextLong();
		primeFactorList = findLongPrimeFactor(number);
		for(int i = 0; i < primeFactorList.size(); i++) {
			System.out.println("Prime factor of " + number + " is: " + primeFactorList.get(i));
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Integer> getPrimeFactorList() {
		return primeFactorList;
	}

	public void setPrimeFactorList(List<Integer> primeFactorList) {
		this.primeFactorList = primeFactorList;
	}
}
