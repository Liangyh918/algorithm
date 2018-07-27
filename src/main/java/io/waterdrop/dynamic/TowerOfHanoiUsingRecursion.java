package io.waterdrop.dynamic;

import java.util.Scanner;

public class TowerOfHanoiUsingRecursion {
	public static void shiftTower(int n, String startPole, String intermediatePole, String endPole) {
		if(n==0) return;

		shiftTower(n-1,startPole,endPole,intermediatePole);
		System.out.println("move "+n+" from "+startPole+" to "+endPole);
		shiftTower(n-1,intermediatePole,startPole,endPole);
	}
	
    public static void main(String[] args)
    {
        System.out.print("Enter number of discs on Pole 1: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfDiscs = scanner.nextInt(); //input of number of discs on pole 1
        shiftTower(numberOfDiscs, "Pole1", "Pole2", "Pole3"); //Shift function called
    }
}
