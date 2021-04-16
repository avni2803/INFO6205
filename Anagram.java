package class12;

import java.util.Arrays;

public class Anagram {
	 static boolean isAnagram(char[] str1, char[] str2) 
	 
	 
	    { 
	        // calculating lengths of both strings 
	        int a1 = str1.length; 
	        int a2 = str2.length; 
	  
	        // To check if length of both strings is same or not to check if strings are anagram.
	        if (a1 != a2) 
	            return false; 
	  
	        // Sorting both strings 
	        Arrays.sort(str1); 
	        Arrays.sort(str2); 
	  
	        // Compare sorted strings 
	        for (int i = 0; i < a1; i++) 
	            if (str1[i] != str2[i]) 
	                return false; 
	  
	        return true; 
	    } 
	public static void main(String[] args) {
	
		
		char str1[]= {'s','i','l','e','n','t'};
		char str2[]= { 'l','i','s','t','e','n'};
		
		if(isAnagram(str1,str2))
		{
			System.out.println("strings are anagram");
		}
		else
		{
		System.out.println("strings are not anagram");
		}
		

	}

}
