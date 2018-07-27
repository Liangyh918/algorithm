package io.waterdrop.String;

import java.util.Arrays;

public class KMP {

	private static int[] computePrefixFunction(String matcher) {
		int[] P = new int[matcher.length()];
		int p = 0; // error point
		P[0] = 0;// error point
		// 外层循环是针对matcher每一位计算前缀与后缀的公共长度
		for (int i = 1 /* error point */; i < P.length; i++) {
			// 内层循环是，当计算前i个字符出现后缀与前缀不匹配的情况时，缩短共同字串长度
			while (matcher.charAt(i) != matcher.charAt(p)/*p作为索引使用*/ && p > 0)
			{
				p = P[p - 1];/* error point */
			}

			if (matcher.charAt(i) == matcher.charAt(p)) {
				p++;/* error point */  //p自增起到两个效果，1，作为本次比较的位置索引，自增则变为本次比较的字符串的长度，
				//2.自增之后作为下次比较时使用的索引
			}
			
			P[i] = p;/* error point */  //p作为长度使用
		}
		
		return P;
	}

	
	public static void KMPmatcher(String T,String P){
		int m = T.length();
		int n = P.length();
		int[] pi = computePrefixFunction(P);
		int q = 0;
		for (int i = 0; i < m; i++) {
			while(q>0&&T.charAt(i)!=P.charAt(q)){
				q=pi[q-1];
			}
			
			if(T.charAt(i)==P.charAt(q)){
				q++;
			}
			
			if(q==n){
				System.out.println(P+" starts at "+(i-n+1));
				q = pi[q-1];//error point
			}
		}
	}
	public static void main(String[] args) {
		String str = "aaaaaad";
		int P[] = new int[str.length()];
		P = computePrefixFunction(str);
		System.out.println(Arrays.toString(P));
		
		KMPmatcher("aaaaaadad","ad");
	}
}
