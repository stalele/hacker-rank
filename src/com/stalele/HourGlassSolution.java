package com.stalele;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/***
 * The problem is 
 * You are given a  2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4
 * @author stalele
 *
 */

public class HourGlassSolution {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }*/
		//int[] allSum = new int[24]; 
		/**
		 * 
-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5
		 */
	
		
		//int arr[][] = new int [][]{{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,9,2,-4,-4,0},{0,0,0,-2,0,0},{0,0,-1,-2,-4,0}};
		int arr[][] = new int[][] {{-1,-1,0,-9,-2,-2},{-2,-1,-6,-8,-2,-5},{-1,-1,-1,-2,-3,-4},{-1,-9,-2,-4,-4,-5},{-7,-3,-3,-2,-9,-9},{-1,-3,-1,-2,-4,-5}};
		int sum =0;
		int result =Integer.MIN_VALUE;
		int rowCounter =0,i=0, j=0, startCoulmn = 0, columnCounter = 0;
		for(columnCounter = 0; columnCounter<4; columnCounter++) {
			for(rowCounter =0;rowCounter<4;rowCounter++) {
				sum =0;
				i= rowCounter;
				j= columnCounter;
				sum = sum + arr[i][j] + arr[i][++j] + arr[i][++j];
				i++;
				j=columnCounter+1;
				sum = sum + arr[i][j];
				i++;
				j=columnCounter;
				sum = sum + arr[i][j] + arr[i][++j] + arr[i][++j];
				System.out.println("sum of matris is -> " + sum);
				result = Math.max(result, sum);
			}
			
			result = Math.max(result, sum);
			
		}
		System.out.println(result);

	}   

}
