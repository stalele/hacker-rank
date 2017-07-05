package com.stalele;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StairCase {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[][] str = new String[n][n];
		int pos = n-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<pos;j++){
				str[i][j] = " ";
				System.out.print(" ");
			}

			for(int k=pos;k<n;k++){
				str[i][k] = " ";
				System.out.print("#");
			}
			pos--;
			System.out.println();
		}

	}
}
