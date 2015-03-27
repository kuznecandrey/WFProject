package org.wfproject;

import java.util.ArrayList;
import java.util.Arrays;


public class CVTasks {

	
	
	
	/**
	 * Something like factorial, but you can specify start number to calculate. Example: factr(3,5) is 3*4*5 = 60
	 * @param start
	 * @param n
	 * @return
	 */
	private static int factr(int start, int n){
		int res = 1; 
		for (int i = start; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	/**
	 * Number of combination of n by m-size group
	 * @param n
	 * @param m
	 * @return
	 */
	private static int combination(int n, int m){
		if (n == m)
			return 1;
		return factr(m+1,n)/ factr(1,n-m);
	}
	
	
	/**
	 * Combinations of array str. Each element is written to list res.
	 * @param res
	 * @param prefix
	 * @param str
	 */
	private static void variant(ArrayList<String> res, String prefix, char[] str) {
		if (prefix.length() == str.length)
			res.add(prefix);
		else{
			for (int i = 0; i < str.length; i++) {
				if (!prefix.contains(""+str[i])){
					variant(res, prefix+str[i], str);
				}
			}
		}
	}
	private static <T> void task1(T [] sortedArray){
		System.out.println("Source array: "+Arrays.asList(sortedArray));
		Tree<T> t = new Tree<T>();
		t.fillBySortedArray(sortedArray);
		System.out.print("Result: ");
		t.print();
		System.out.println();
	}
	private static void task2(int number){
		System.out.println("Source number: "+number);
		int [] coins = {25,10,5,1};
		int cntAll = 0;
		int cntDivisible = 0;
		for (int c : coins) {
			if (number >= c)
				cntAll++;			//The number of coins that are less then source number
			if (number % c == 0)
				cntDivisible++;		//The number of coins that can use to exchange source number
		}
		int res = cntDivisible;		//You use one type of coin if source number is divisible by this coin
		for (int i = 2; i <= cntAll; i++) {
			for (int j = 1; j <= cntDivisible; j++) {
				res += combination(cntAll - j, i-1);
			}
		}
		System.out.println("Result: "+res);
	}
	private static void task3(String str) {
		System.out.println("Source string: "+str);
		ArrayList<String> res = new ArrayList<String>();
		variant(res,"",str.toCharArray());
		System.out.println("Result ("+res.size()+"): "+res);
	}
	public static void main(String[] args) throws Exception {
		System.out.println("\n==========Task 1==========\n");
		task1(new Integer[]{1,2,3,4,5,5,6,7,8});
		System.out.println("\n==========Task 2==========\n");
		task2(41);
		System.out.println("\n==========Task 3==========\n");
		task3("ABC");
	}
}
