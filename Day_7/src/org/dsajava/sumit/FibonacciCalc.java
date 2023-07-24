package org.dsajava.sumit;

import java.util.HashMap;
import java.util.Map;

public class FibonacciCalc {

	private static Map<Integer,Long> memo = new HashMap<>();

	public static long FibonacciMemo(int n) {
		if(n<=1) {
			return n;
		}
		if(memo.containsKey(n)) {
			return memo.get(n);
		}

		long fib = FibonacciMemo(n-1) + FibonacciMemo(n-2);
		memo.put(n,fib);
		return fib;
	}
	public static void main(String[] args) {
		int n = 10;
		long result = FibonacciMemo(n);
		System.out.println("\n\nFibnacci of "+n+ " is:"+result);
	}

}