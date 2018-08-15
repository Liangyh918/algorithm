package io.waterdrop.dynamic;

/**
 * 关键点在：对长度为i的rod，通过比较切割出长度为j（0<j<i）的rod的收益，选出收益最大的情况。
 * i要从小到大计算，这样对于更大的i可以利用历史信息计算出收益
 * @author liangyh
 *
 */
public class RodCutting {
	
	private static int cutRod(int price[],int n)
	{
		int val[] = new int[n+1];
		val[0] = 0;

		for (int i = 1; i<=n; i++)
		{
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val,price[j] + val[i-j-1]);
		  
       val[i] = max_val;
		}

		return val[n];
	}

	//main function to test
	public static void main(String args[])
	{
		int arr[] = new int[] {2, 5, 13, 19, 20};
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " +
							cutRod(arr, size));
	}
}
