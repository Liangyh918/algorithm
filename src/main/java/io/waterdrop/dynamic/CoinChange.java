package io.waterdrop.dynamic;

import java.util.Iterator;

/**
 * 找零算法的递推公式为 combinations[j] += combinations[j-i] (j为总金额，i为零钱金额)
 * 
 * @author liangyh
 *
 */
public class CoinChange {

	private static int getCombinationNum(int coins[], int amount) {
		int[] combinations = new int[amount + 1];
		combinations[0] = 1;
		for (int i : coins) {
			for (int j = i; j <= amount; j++) {
				//if(j>=i){
					combinations[j] += 	combinations[j-i];
				//}
				
			}
		}
		return combinations[amount];
	}
	
	public static void main(String[] args) {
		int[] coins={1,2,5};
		System.out.println(getCombinationNum(coins,8));
		
	}
}
