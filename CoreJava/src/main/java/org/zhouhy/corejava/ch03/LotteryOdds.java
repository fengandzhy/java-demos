package org.zhouhy.corejava.ch03;

import java.util.Scanner;

public class LotteryOdds {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("How many numbers do you need to draw? ") ;
		int k = in.nextInt();
		
		System.out.print("What is the highest number you can draw? ") ;
		int n = in.nextInt();
		
		int lotterOdds = 1;
		for(int i=0;i<k;i++) {
			lotterOdds = lotterOdds * (n-i)/(i+1);
		}
		System.out.println(lotterOdds);		
		in.close();
	}

}
