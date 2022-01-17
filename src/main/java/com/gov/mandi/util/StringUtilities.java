package com.gov.mandi.util;

import java.util.Arrays;

public class StringUtilities {
	
	public static String toUpperCamelCase(String text)
	{
		text = text.toLowerCase();
		
		String[] obj = text.split(" ");
		StringBuilder str = new StringBuilder();
		
		//Arrays.stream(obj).map(e -> String.valueOf(text.charAt(0)).toUpperCase()+e.substring(1,e.length()-1));
		
		Arrays.stream(obj).
		map(e -> String.valueOf(e.charAt(0)).toUpperCase()+e.substring(1,e.length()))
		.forEach(j -> str.append(j+" "));;
		System.out.println(String.valueOf(str).trim());
		return  String.valueOf(str).trim();
		
	}
	
	public static void main(String []args)
	{
		String text = "ANDHRA PRADESH";
		text = text.toLowerCase();
		String[] obj = text.split(" ");
		StringBuilder str = new StringBuilder();
		
		Arrays.stream(obj).
				map(e -> String.valueOf(e.charAt(0)).toUpperCase()+e.substring(1,e.length()))
				.forEach(j -> str.append(j+" "));;
				System.out.println(String.valueOf(str).trim());
		
	}
}
