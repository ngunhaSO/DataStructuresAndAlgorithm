package com.jacky.DSAndDM.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionProblem {

	public String reverseString(String s) {
		if (s.length() == 0) {
			return "";
		} else {
			return reverseString(s.substring(1)) + s.charAt(0);
		}
	}

	public String reverseStringIteratively(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public int factorialIteratively(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public int sumList(List<Integer> list) {
		if (list.size() == 0) {
			return 0;
		} else {
			int basevalue = list.get(0);
			list.remove(0);
			return basevalue + sumList(list);
		}
	}

	public int sumListIteratively(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			count = count + list.get(i);
		}
		return count;
	}

	public int fib(int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public int fibIteratively(int n) {
		int prev1 = 0;
		int prev2 = 1;
		for (int i = 0; i < n; i++) {
			int save = prev1;
			prev1 = prev2;
			prev2 = save + prev2;
		}
		return prev1;
	}

	public boolean isPalin(String s) {
		if(s.length() == 1){
			return true;
		}
		else {
			if(s.charAt(0) == s.charAt(s.length() - 1)){
				return isPalin(s.substring(1, s.length() - 1));
			}
			else {
				return false;
			}
		}
	}

	public boolean isPalinIteratively(String s) {
		int outerbound = s.length() - 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(outerbound)) {
				return false;
			} else {
				outerbound--;
				continue;
			}
		}
		return true;
	}

	public String replaceString(String s, char from, char to) {
		if(s.length() == 0){
			return "";
		}
		else {
			char first =s.charAt(0);
			if(first == from){
				first = to;
			}
			return first + "" + replaceString(s.substring(1), from, to);
		}
		
		
	}

	public String replaceStringIteratively(String s, char from, char to) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == from) {
				sb.setCharAt(i, to);
			}
		}
		return sb.toString();
	}

	public int countOccurence(String s, char o) {
		if(s.length() == 0){
			return 0;
		}
		else {
			if(s.charAt(0) == o){
				return countOccurence(s.substring(1), o) + 1;
			}
			else {
				return countOccurence(s.substring(1), o);
			}
		}
	}

	public int countOccurenceIteratively(String s, char o) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == o) {
				count++;
			}
		}
		return count;
	}

	public String replacePi(String s, String replace) {
		int index = s.indexOf("pi");
		if (index < 0) {
			return s;
		}
		int endIndex = index + "pi".length();
		return s.substring(0, index) + replace
				+ replacePi(s.substring(endIndex), replace);
	}

	public String replacePiIteratively(String s, String replace) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'p') {
				sb.append(s.charAt(i));
			} else {
				sb.append("3.14");
				i++;
			}
		}
		return sb.toString();
	}

	public int countWord(String s, String toCount) {
		int index = s.indexOf(toCount);
		if (index < 0) {
			return 0;
		}
		int endIndex = toCount.length();

		return 1 + countWord(s.substring(endIndex), toCount);
	}

	public int count7(int n) {
		if (n == 0)
			return 0;
		if (n % 10 == 7)
			return 1 + count7(n / 10);
		return count7(n / 10);
	}

	public int sumDigits(int n) {
		if (n == 0) {
			return 0;
		} else {
			int result = n % 10;
			return sumDigits(n / 10) + result;
		}
	}

	public void displayPermutation(String s) {
		displayPermutation("", s);
	}

	private void displayPermutation(String s1, String s2) {
		if(s2.length() == 0){
			System.out.println(s1);
		}
		else {
			for(int n = 0; n < s2.length(); n++){
				displayPermutation(s1 + s2.charAt(n), s2.substring(0,n) + s2.substring(n+1, s2.length()));
			}
		}
	}
	
	public String reverseWord(String s){
		StringBuilder sb = new StringBuilder();
		String[] words = s.split("\\s+");
		for(int i = words.length - 1; i >= 0; i--){
			sb.append(words[i]).append(' ');
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		RecursionProblem r = new RecursionProblem();

		System.out.println("-----------------------------------");
		System.out.println("reverse string");
		String s = "hello";
		System.out.println("recursion: " + r.reverseString(s));
		System.out.println("Non recursion: " + r.reverseStringIteratively(s));

		System.out.println("-----------------------------------");
		System.out.println("factorial");
		int n = 4;
		System.out.println("recursion: " + r.factorial(n));
		System.out.println("non recursion: " + r.factorialIteratively(n));

		System.out.println("-----------------------------------");
		System.out.println("sum list");
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("non recursion: " + r.sumListIteratively(list));
		System.out.println("recursion: " + r.sumList(list));

		System.out.println("-----------------------------------");
		System.out.println("fibonacci");
		System.out.println("recursion: " + r.fib(4));
		System.out.println("non recursion: " + r.fibIteratively(4));

		System.out.println("-----------------------------------");
		System.out.println("is string palindrom");
		String s1 = "121";
		System.out.println("non recursion: " + r.isPalinIteratively(s1));
		System.out.println("is string palin: " + r.isPalin(s1));

		System.out.println("-----------------------------------");
		System.out.println("replace string");
		String s2 = "steveeee";
		System.out.println("recursion: " + r.replaceString(s2, 'e', 'a'));
		System.out.println("non recursion: "
				+ r.replaceStringIteratively(s2, 'e', 'a'));

		System.out.println("-----------------------------------");
		System.out.println("count occurences");
		String s3 = "aaaabsc";
		System.out.println("non recursion: "
				+ r.countOccurenceIteratively(s3, 'a'));
		System.out.println("recursion: " + r.countOccurence(s3, 'a'));

		System.out.println("-----------------------------------");
		System.out.println("replace word");
		String s4 = "xpipipix";
		System.out.println("recursion: " + r.replacePiIteratively(s4, "3.14"));
		System.out.println("recursion: " + r.replacePi(s4, "3.14"));

		System.out.println("-----------------------------------");
		System.out.println("count word");
		String s5 = "abcddabceabec";
		System.out.println("recursion: " + r.countWord(s5, "abc"));

		System.out.println("-----------------------------------");
		System.out.println("count 7");
		System.out.println("recursion: " + r.count7(71777));

		System.out.println("-----------------------------------");
		System.out.println("sum digits");
		System.out.println("recursion: " + r.sumDigits(1234));

		System.out.println("-----------------------------------");
		System.out.println("permutation");
		r.displayPermutation("abc");
		
		System.out.println("------------------------------------");
		System.out.println("reverse word good morning, how are you");
		System.out.println(r.reverseWord("good morning, how are you"));
	}
}
