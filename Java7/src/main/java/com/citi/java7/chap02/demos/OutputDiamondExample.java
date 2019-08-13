package com.citi.java7.chap02.demos;

/**
 *  ‰≥ˆ¡‚–Œ
 * */
public class OutputDiamondExample {

	public static void main(String[] args) {
		printDiamond(11);
	}
	
	public static void printDiamond(int length) {
		if(length<3) {
			return;
		}
		int width = 0;
		if(length%2==0) {
			width =length+1;
			length = length+1;
		}else{
			width = length;
		}
		int center = width/2;
		int offset =0;
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				if(j==center+offset||j==center-offset) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}								
			}
			if(i>=length/2) {
				--offset;
			}else {
				++offset;
			}
			
			System.out.println();
		}
	}

}
