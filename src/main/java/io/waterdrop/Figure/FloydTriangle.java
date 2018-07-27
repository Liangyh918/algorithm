package io.waterdrop.Figure;

public class FloydTriangle {
	public static void floydTriangle(int rownum) {
		int n=1;
		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(n++ + " ");
			}
			System.out.println();

		}
	}
	
	public static void main(String[] args) {
		floydTriangle(5);
	}

}
