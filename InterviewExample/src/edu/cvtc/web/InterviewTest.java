/**
 * 
 */
package edu.cvtc.web;

import java.util.Arrays;

/**
 * @author jvollmer
 *
 */
public class InterviewTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays.stream(intMethod(5,35)).forEach(number -> System.out.println(checkNumber(number)));
	}

	static int[] intMethod(int start, int end){ 
		int initValue[]= new int[end-start + 1];
		for (int i=start - 1 ;i<end;i++){
			initValue[i-start + 1] = i+1;
		}
		return initValue;
	}

	static String checkNumber(int val){
		if(val % 3 == 0 && val % 5 == 0){
			return val + " Fizz Buzz";
		}else if(val % 3 == 0){
			return val + " Fizz";
		}else if(val % 5 == 0){
			return val + " Buzz";
		}else{
			return "" + val;
		}
	}
}



