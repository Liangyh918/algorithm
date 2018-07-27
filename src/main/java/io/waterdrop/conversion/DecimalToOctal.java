package io.waterdrop.conversion;

import java.util.Scanner;
/**
 * 有两种解法，思路相同：拿10进制数除8，拿余数进行拼接，差别在于拼接的方式
 * 1.字符串拼接
 * 2.整型拼接
 * 
 * @author liangyh
 *
 */


public class DecimalToOctal {
	
	//整型拼接法
	public static int decimalToOctalFirstWay(String[] args)
	  {
	    Scanner sc=new Scanner(System.in);
	    int n,k,d,s=0,c=0;
	    System.out.print("Decimal number: ");
	    n=sc.nextInt();
	    k=n;
	    while(k!=0)
	    {
	      d=k%8;
	      s+=d*(int)Math.pow(10,c++);
	      k/=8;
	    }
	   
	    System.out.println("Octal equivalent:"+s);
	    sc.close();
	    
	    return s;
	  }
	
	
	public static int decimalToOctalSecondWay(int decimalNum) {
		StringBuilder octalString = new StringBuilder("");
		int remainder = 0;

		while (decimalNum > 0) {
			remainder = decimalNum % 8;
			octalString.append(remainder);
			decimalNum = decimalNum / 8;
		}
		octalString.reverse();
		return Integer.valueOf(octalString.toString());
	}
	
	
}
