package com.osfg.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* Problem Name is &&& Largest Number &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 Instructions to candidate.
  1) Given an array of positive integers, arrange the numbers to form the largest possible number
  Input: [1, 8, 7, 9, 4]
  Output: 98741

  Input: [604, 6, 112, 10, 5, 61, 9 ]
  Output: 9661604511210

  2) Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
  3) Consider adding some additional tests in doTestsPass().
  4) If time permits, some possible follow-ups.
*/

public class FormLargestNumber
{
  /**
   * String findLargestNum()
   * Returns the String value of the largest integer that can be formed by arranging the numbers in the input array of positive integers
   *   Input: [1, 8, 7, 9, 4]
   *   Output: 98741
   */
	  public static String findLargestNum(List<Integer> numArr) {
		    Collections.sort(numArr, new FormLargestNumber.IntComparator());
		    StringBuffer sb = new StringBuffer();
		    for(Integer intg : numArr)
		    {
		      sb.append(intg.toString());
		    }
		    System.out.println(sb.toString());
		    return sb.toString();
		  }
  
  static class IntComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1.equals(o2)) {
			return 0;
		}
		else {
			char[] no1String = o1.toString().toCharArray();
			char[] no2String = o2.toString().toCharArray();
			int lowestLength = no1String.length > no2String.length? no2String.length : no1String.length;
			//sort in desc order
			for(int i = 0; i< lowestLength; i++) {
				if(no1String[i] > no2String[i]) {
					return -1;
				}
				else if (no1String[i] < no2String[i]) {
					return 1;
				}
			}
			/**
			 * if it is same so far check check next character of largest array
			 * At this point you can be sure both chars are not same and 
			 * also they are not equal
			 * So check next char of largest array and compare it with 1st char of lowest no
			 * remember we are sorting ind desc
			 */
			if(no1String.length == lowestLength)
			{
				//no1String is smaller
				if(no2String[no1String.length] > no1String[0])
				{
					return 1;
				}
				else 
				{
					return -1;
				}
			}
			else {
				//no2String is smaller
				if(no1String[no2String.length] > no2String[0])
				{
					return -1;
				}
				else 
				{
					return 1;
				}
			}			
		}
	}
	  
  }

  /**
   * int doTestsPass()
   * Returns 1 if all tests pass. Otherwise returns 0.
   */
  public static void doTestsPass()
  {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    boolean result = true;

    result = result && (Objects.equals(findLargestNum(Arrays.asList(7, 1, 9, 4, 2)), "97421"));
    result = result && (Objects.equals(findLargestNum(Arrays.asList(604, 6, 112, 10, 5, 61, 9)), "9661604511210"));

    if( result )
    {
      System.out.println("All tests pass\n");
    }
    else
    {
      System.out.println("There are test failures\n");
    }
  }

  /**
   * Execution entry point.
   */
  public static void main(String[] args)
  {
    doTestsPass();
  }

}
