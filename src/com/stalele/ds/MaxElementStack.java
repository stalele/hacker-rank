package com.stalele.ds;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxElementStack {
	 private int size;
	  private int data[];
	  private int top;
	  private int max;
	  private int track[];
	   
	  public MaxElementStack(int size) {
	    this.size = size;
	    data = new int[size];
	    track = new int[size];
	    top = 0;
	    max = 0;
	  }
	  
	  public void push(int x) {
	    if(top>=size){
	      System.out.println("Stack overflow");
	    } else {
	      max = Math.max(x, getMaxElement());
	      data[top] = x;
	      track[top] = max;
	      top++;
	      display();
	    }
	  }
	  
	  public int getMaxElement() {
		  int topElement = 0;
		  if(top >= size) {
			  topElement = track[size -1];
			  //System.out.println(track[size -1]);  
		  } else if( top > 0){
			  int temp = top;
			  temp --;
			  topElement = track[temp];  
		  }    
		  return topElement;
	  }
	  
	  public void delete() {
	    if(top <= 0) {
	      System.out.println("Stack underflow");
	    } else {
	      top --;
	      data[top] = 0;
	      track[top] = 0;
	      display();
	    }
	  }

	  public void display() {
			for(int i : track){
				System.out.print(i + "||");
			}

			System.out.println();
		}
	  
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	      Scanner scanner = new Scanner(System.in);
			int size = scanner.nextInt();
			MaxElementStack sol = new MaxElementStack(size);
	      for(int i =0;i< size; i++) {
			int action = scanner.nextInt();
			if(action == 2){
				sol.delete();
			} else if(action == 3){
				System.out.println(sol.getMaxElement());
			} else if(action == 1) {
				int data = scanner.nextInt();
				sol.push(data);
			}
	      }
	    }
}