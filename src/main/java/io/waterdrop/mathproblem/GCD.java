package io.waterdrop.mathproblem;

public class GCD {
/*	public static int getGcdWithEculid(int a,int b){		
		while()
		return b;
		
	} */
	
	
    public static int gcd(int num1, int num2) {
    	
        int gcdValue = num1 % num2;
        while (gcdValue != 0) {
        	
            num1 = num2;
            num2 = gcdValue;
            gcdValue = num1 % num2;
        }
        return num2;
    }
	public static int gcd(int[] number) {
		  int result = number[0];
		  for(int i = 1; i < number.length; i++) 
			  //call gcd function (input two value)
		          result = gcd(result, number[i]);
		  
		  return result;
	}

	public static void main(String[] args) {
		int[] myIntArray = {64,32,16*7};
		//call gcd function (input array)
                System.out.println(gcd(myIntArray));
    }
}
