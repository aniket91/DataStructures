package com.osfg.questions;


/**
 * 
 * @author athakur
 * Question  : To design a tiny URL or URL shortener
 * 
 * Solution : One way to achieve this would be hashing. But there may be collision and two short
 * string may map to same long one. Better was is to use integer id stored in DB
 */
public class ShortURLGenerator {
	
	private static final String CHAR_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = CHAR_MAP.length();
	
	private static String idToShortURL(int id) {
		
		StringBuilder sb = new StringBuilder();
		
		while(id > 0) {
			sb.append(CHAR_MAP.charAt(id%BASE));
			id = id / BASE;
		}
		return sb.reverse().toString();
	}
	
	
	private static int shortURLtoID(String shortUrl) {
		int no = 0;
		for(char c : shortUrl.toCharArray()) {
			no = no * BASE + CHAR_MAP.indexOf(c);
		}
		return no;
	}
	
	//tests - main method
	public static void main(String args[]) {
		
		String shortUrl = idToShortURL(1234);
		System.out.println("shortUrl : " + shortUrl);
		System.out.println("ID : " + shortURLtoID(shortUrl));
		
	}
	
	
}
