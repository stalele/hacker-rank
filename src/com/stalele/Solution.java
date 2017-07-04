package com.stalele;

import java.util.Scanner;

public class Solution {
	static int arr[];

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		/*Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = scanner.nextInt();
		}*/
		arr = new int[]{1,-2,4,-5,1};

		//example = {1,-2,4,-5,1}

		int counter = 0;
		int size = 5;
		for(int i=0;i<size;i++){
			int sum = 0;
			sum+=arr[i];
			if(sum < 0) {
				System.out.println("single " + arr[i]);
				counter++;
			}
			for(int endPosition = i + 1; endPosition<size;endPosition++) {
				sum+=arr[endPosition];
				//System.out.println("subarray i, end" +i +endPosition+ "->" + result);
				if(sum < 0) {
					counter++;
				}
			}

		}

		System.out.println(counter);

	}


}
