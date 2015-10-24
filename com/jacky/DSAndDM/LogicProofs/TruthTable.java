package com.jacky.DSAndDM.LogicProofs;

import java.util.Scanner;

public class TruthTable {

	// *****************************************//
	// 											//
	// 				Member Variables 			//
	// 											//
	// *****************************************//
	private String p;
	private String q;
	private String[] truthValues = {"True","False"};
	private String isContinue = "Yes";
	// *****************************************//
	// 											//
	// 				Constructors 				//
	// 											//
	// *****************************************//
	public TruthTable() {

	}

	public TruthTable(String p, String q) {
		this.p = p;
		this.q = q;
	}

	// User Input and Display Result
	public void ShowResult() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("	Truth Table");
		System.out.println("-----------------------------\n");
		System.out.println("Enter truth value of the propositions p and q");
		System.out.println("True for true");
		System.out.println("False for false");
		
		while(isContinue.equals("Yes") || isContinue.equals("yes")) {
			
			System.out.println("Value of p:");
			p = scan.next();
			while (!(p.equals(truthValues[0]) || p.equals(truthValues[1]))) {
				System.out.println("Invalid value of proposition p. Reenter please!");
				p =scan.next();
			}
			
			System.out.println("Value of q:");
			q = scan.next();
			while (!(q.equals(truthValues[0]) || q.equals(truthValues[1]))) {
				System.out.println("Invalid value of proposition q. Reenter please!");
				q =scan.next();
			}
			System.out.println("\nResult\n");
			Conjunction(p, q);
			Disjunction(p, q);
			ExclusiveOr(p, q);
			Conditional(p,q);
			BioConditional(p,q);
			System.out.println();
			System.out.println("Continue (Yes/No)?");
			isContinue = scan.next();
			if(!(isContinue.equals("Yes") || isContinue.equals("yes"))) {
				System.out.println("Program Terminated!");
			}
			System.out.println();
		}
		
	}
	
	private void Conjunction(String p, String q) {
		System.out.println("Conjunction");
		System.out.println("  p	|    q		|	p ^ q");
		System.out.println("-----------------------------------------");
		if(p.equals(truthValues[0]) && q.equals(truthValues[0])) {	
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		else {
			System.out.println(p + "	|   " + q + "	|	" + "False");
		}
		System.out.println();
	}
	
	private void Disjunction(String p, String q) {
		System.out.println("Disjunction");
		System.out.println("  p	|    q		|	p v q");
		System.out.println("-----------------------------------------");
		if(p.equals(truthValues[0]) && q.equals(truthValues[0])) {	
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		else if(p.equals(truthValues[0]) || q.equals(truthValues[0])){
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		else {
			System.out.println(p + "	|   " + q + "	|	" + "False");
		}
		System.out.println();
	}
	
	private void ExclusiveOr(String p, String q) {
		System.out.println("ExclusiveOr");
		System.out.println("  p	|    q		|	p xor q");
		System.out.println("-----------------------------------------");
		if((p.equals(truthValues[0]) && q.equals(truthValues[0])) || (p.equals(truthValues[1]) && q.equals(truthValues[1]))) {
			System.out.println(p + "	|   " + q + "	|	" + "False");
		}
		else {
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		System.out.println();
	}
	
	private void Conditional(String p, String q) {
		System.out.println("Conditional");
		System.out.println("  p	|    q		|	p -> q");
		System.out.println("-----------------------------------------");
		if(q.equals("False")) {
			System.out.println(p + "	|   " + q + "	|	" + "False");
		}
		else {
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		System.out.println();
	}
	
	private void BioConditional(String p, String q) {
		System.out.println("BiConditional");
		System.out.println("  p	|    q		|	p <-> q");
		System.out.println("-----------------------------------------");
		if((p.equals(truthValues[0]) && q.equals(truthValues[0])) || (p.equals(truthValues[1]) && q.equals(truthValues[1]))) {
			System.out.println(p + "	|   " + q + "	|	" + "True");
		}
		else {
			System.out.println(p + "	|   " + q + "	|	" + "False");
		}
		System.out.println();
	}
	// *****************************************//
	// 											//
	// 				Getters/Setters 			//
	// 											//
	// *****************************************//
	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

}
