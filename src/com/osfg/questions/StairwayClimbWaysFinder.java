package com.osfg.questions;

/**
 * 
 * @author athakur
 *
 * Question : There are N stairs that you need to take to the kth floor. 
 * You can either climb 1 stair at a time or 2 stair at a time. 
 * In how many ways you can cover N stairs.
 */
public class StairwayClimbWaysFinder {
	
	public static int findWays(int stairsClimbed, int totalStairs) {
		
		if(stairsClimbed == totalStairs) {
			return 1;
		}
		
		if((totalStairs - stairsClimbed) >= 2) {
			return findWays(stairsClimbed + 2, totalStairs) + findWays(stairsClimbed + 1, totalStairs);
		}
		else if ((totalStairs - stairsClimbed) == 1) {
			return findWays(stairsClimbed + 1, totalStairs);
		}
		return 0;
	}
	
	/**
	 * Secondary approach - it is infact a fibanacci series
	 * f(n) = f(n-1) + f(n-2), n>2, f(1) = 1 and f(2) = 2
	 * @param totalStairs
	 * @return
	 */
	public static int findWays(int totalStairs) {
		
		if(totalStairs == 1) {
			return 1;
		}
		else  if (totalStairs == 2) {
			return 2;
		}
		else {
			return ((findWays(totalStairs-1) ) + (findWays(totalStairs-2) ));
		}
		
	}
	
	//tests - main method
	public static void main(String args[]) {
		
		System.out.println("No Of ways for 2 stairs : " + findWays(0, 2));
		System.out.println("No Of ways for 4 stairs : " + findWays(0, 4));
		
		System.out.println("No Of ways for 2 stairs : " + findWays(2));
		System.out.println("No Of ways for 4 stairs : " + findWays(4));
		
	}
	

}
