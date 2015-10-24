package com.jacky.DSAndDM.LogicProofs;

import java.util.Scanner;

public class BitwiseString {

	// *****************************************//
	// 											//
	// 				Member Variables 			//
	// 											//
	// *****************************************//	
	private String a;
	private String b;
	private int length;
	private String isContinue = "Yes";
	private int[] bitwiseArrayA;
	private int[] bitwiseArrayB;
	private int[] bitwiseResult;
	// *****************************************//
	// 											//
	// 				Constructors 				//
	// 											//
	// *****************************************//
	public BitwiseString() {
		
	}
	
	public BitwiseString(int length) {
		this.length = length;
		bitwiseArrayA = new int[length];
		bitwiseArrayB = new int[length];
	}

	// User Input and Display Result
	public void ShowResult() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("	Bitwise String calculation");
		System.out.println("----------------------------------------\n");
		System.out.println("Enter value of the bitwise a and b with value of 10");
		System.out.println("Example valid input (contains only 0 or 1): 101100");
		System.out.println("Example invalid input (contains not only 0 or 1): 131100");
		System.out.println();
		
		while(isContinue.equals("Yes") || isContinue.equals("yes")) {	
			System.out.println("Length of bitwise string:");
			length = scan.nextInt(); //ignore number-string check here
			
			System.out.println("Value of p:");
			a = scan.next();
			while(a.length() > getLength()){
				System.out.println("Value of bitwise a exceeds length. Reenter please!");
				a =scan.next();
			}
			
			System.out.println("Value of q:");
			b = scan.next();
			while(b.length() > getLength()){
				System.out.println("Value of bitwise b exceeds length. Reenter please!");
				b =scan.next();
			}
			
			System.out.println("\nResult\n");
			BitwiseAnd(a,b);
			BitwiseOr(a,b);
			BitwiseExclusiveOr(a, b);
			System.out.println();
			System.out.println("Continue (Yes/No)?");
			isContinue = scan.next();
			if(!(isContinue.equals("Yes") || isContinue.equals("yes"))) {
				System.out.println("Program Terminated!");
			}
			System.out.println();
		}
		
	}		
		
	public void BitwiseAnd(String p, String q) {
		int arrayLength = p.length();
		bitwiseArrayA = new int[arrayLength];
		bitwiseArrayB = new int[arrayLength];
		bitwiseResult = new int[arrayLength]; //either p or q works
		for(int i = 0; i < arrayLength; i++) {
			bitwiseArrayA[i] = Character.getNumericValue(p.charAt(i));
			bitwiseArrayB[i] = Character.getNumericValue(q.charAt(i));
		}
		
		for(int i = arrayLength - 1; i >= 0; i--) {
			if( (bitwiseArrayA[i] == 1) && (bitwiseArrayB[i]) == 1) {
				bitwiseResult[i] = 1;
			}
			else {
				bitwiseResult[i] = 0;
			}
		}
		
		System.out.println("Bitwise AND");
		System.out.println("  p		|    q			|	p ^ q");
		System.out.println("-----------------------------------------");
		String result = "";
		for(int i = 0 ; i < bitwiseResult.length; i++) {
			result += bitwiseResult[i];
		}
		System.out.println(p + "	|   " + q + "		|	" + result);
		System.out.println();
	}
	
	
	public void BitwiseOr(String p, String q) {
		int arrayLength = p.length();
		bitwiseArrayA = new int[arrayLength];
		bitwiseArrayB = new int[arrayLength];
		bitwiseResult = new int[arrayLength]; //either p or q works
		for(int i = 0; i < arrayLength; i++) {
			bitwiseArrayA[i] = Character.getNumericValue(p.charAt(i));
		}
		for(int i = 0; i < q.length(); i++) {
			bitwiseArrayB[i] = Character.getNumericValue(q.charAt(i));
		}
		
		for(int i = arrayLength - 1; i >= 0; i--) {
			if( (bitwiseArrayA[i] == 1) || (bitwiseArrayB[i]) == 1) {
				bitwiseResult[i] = 1;
			}
			else if((bitwiseArrayA[i] == 0) && (bitwiseArrayB[i]) == 0) {
				bitwiseResult[i] = 0;
			}
		}
		
		System.out.println("Bitwise OR");
		System.out.println("  p		|    q			|	p v q");
		System.out.println("-----------------------------------------");
		String result = "";
		for(int i = 0 ; i < bitwiseResult.length; i++) {
			result += bitwiseResult[i];
		}
		System.out.println(p + "	|   " + q + "		|	" + result);
		System.out.println();
	}
	
	
	public void BitwiseExclusiveOr(String p, String q) {
		int arrayLength = p.length();
		bitwiseArrayA = new int[arrayLength];
		bitwiseArrayB = new int[arrayLength];
		bitwiseResult = new int[arrayLength]; //either p or q works
		for(int i = 0; i < arrayLength; i++) {
			bitwiseArrayA[i] = Character.getNumericValue(p.charAt(i));
		}
		for(int i = 0; i < q.length(); i++) {
			bitwiseArrayB[i] = Character.getNumericValue(q.charAt(i));
		}
		
		for(int i = arrayLength - 1; i >= 0; i--) {
			if((bitwiseArrayA[i] == 1 && bitwiseArrayB[i] == 1) ||
					(bitwiseArrayA[i] == 0 && bitwiseArrayB[i] == 0)) {
				bitwiseResult[i] = 0;
			}
			else {
				bitwiseResult[i] = 1;
			}
		}
		
		System.out.println("Bitwise XOR");
		System.out.println("  p		|    q			|	p v q");
		System.out.println("-----------------------------------------");
		String result = "";
		for(int i = 0 ; i < bitwiseResult.length; i++) {
			result += bitwiseResult[i];
		}
		System.out.println(p + "	|   " + q + "		|	" + result);
		System.out.println();
	}
	
	
	// *****************************************//
	// 											//
	// 				Getters/Setters 			//
	// 											//
	// *****************************************//
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
}
