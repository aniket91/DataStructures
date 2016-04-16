package com.osfg.utils;

public class Swapper {
	
	public static void swap(char[] array, int x, int y){
		char temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
