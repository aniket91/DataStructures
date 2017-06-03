package com.osfg.questions;

/**
 * 
 * @author athakur
 *
 * Give a circle with center (0,0) and a radius r (integer > 0), 
 * find the number of points (x,y) on the circumference such that x and y both are integers
 * Hint : (x,y) lies on the circumference if X^2 + Y^2 = r^2
 *
 */
public class IntegralPointsOnCirle {
	
	/**
	 * O(N^2) solution
	 * @param radius
	 * @return
	 */
	public static int getIntegralPointsOnCirle(int radius)
	{
		double rSqr = Math.pow(radius, 2);
		int count = 0;
		for (int x = 0; x<= radius; x++)
		{
			for(int y=0; y<=radius; y++)
			{
				double xSqr = Math.pow(x, 2);
				double ySqr = Math.pow(y, 2);
				if(xSqr + ySqr == rSqr)
				{
					count++;
				}
				
			}
		}
		//4 quadrants
		count = count * 4;
		//each x and y cordinates will be counted twice
		count = count -4;
		return count;
	}
	
	/**
	 * Linear solution
	 * @param radius
	 * @return
	 */
	public static int getIntegralPointsOnCirleOptimized(int radius)
	{
		double rSqr = Math.pow(radius, 2);
		int count = 0;
		int x = 1;
		int y = radius -1;
		
		while(x <= y)
		{
			double xSqr = Math.pow(x, 2);
			double ySqr = Math.pow(y, 2);
			double sum = xSqr + ySqr;
			if(sum == rSqr)
			{
				count++;
				x++;
				y--;
			}
			else if (sum < rSqr)
			{
				x++;
			}
			else {
				//sum > rSqr
				y--;
			}
		}
		
		//1 quadrant
		 count = count * 2;
		 //4 quardranrts
		 count = count * 4;
		 //4 axis coordinates _x, -x, y, -y
		 count = count + 4;
		return count;
	}
	
	
	
	
	public static void main(String args[])
	{
		/**
		 * radius = 5
		 * points - (3,4) = 1
		 * same quedrant - *2 : (4,3) : = 2
		 * 4 quadrant : *4 = 8
		 * (5,0) (0,5) (-5,0) (0,-5) : + 4 = 12
		 */
		System.out.println(getIntegralPointsOnCirle(5));
		System.out.println(getIntegralPointsOnCirleOptimized(5));
	}

}
