package io.waterdrop.String;

public class Abecadrian {
	public static boolean isAbecedarianFirst(String word){
		for (int i = 0; i < word.length()-1; i++) {
			if(word.charAt(i)>word.charAt(i+1)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isAbecedariaSecond(String word){
		int index = word.length()-1;
		for (int i = 0; i < index; i++) {
			if(word.charAt(i)<=word.charAt(i+1)){
				
			}
			else{
				return false;
			}
		}
		return true;
		
	}
}
