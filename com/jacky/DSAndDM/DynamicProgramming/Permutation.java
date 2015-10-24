package com.jacky.DSAndDM.DynamicProgramming;

public class Permutation {

	private void permute(String string) {
		permute("", string);
	}

	private void permute(String s1, String s2) {
		if(s2.length() == 0){
			System.out.println(s1);
		}
		else {
			for(int i = 0; i < s2.length(); i++){
				permute(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i+1, s2.length()));
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation();
		p.permute("abc");
	}
}
