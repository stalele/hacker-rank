package com.stalele;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStack {

	int[] stack1;
	int[] stack2;
	int[] stack3;
	int top1;
	int top2;
	int top3;

	int sum1;
	int sum2;
	int sum3;

	int size1, size2, size3;



	public EqualStack(int size1, int size2, int size3){
		stack1 = new int[size1];
		stack2 = new int[size2];
		stack3 = new int[size3];
		sum1 = top1 = 0;
		sum2 = top2 = 0;
		sum3 = top3 = 0;
		this.size1 = size1;
		this.size2 = size2;
		this.size3 = size3;
	}

	public void pushStack1(int data1) {
		if(top1 >= size1){
			System.out.println("stack1 overflow");
		}else{ sum1 += data1;
		stack1[top1] = data1;
		top1++;
		}
	}

	public void pushStack2(int data2) {
		if(top2 >= size2){
			System.out.println("stack2 overflow");
		}else {
			sum2 += data2;
			stack2[top2] = data2;
			top2++;
		} 
	}
	public void pushStack3(int data3) {
		if(top3 >= size3){
			System.out.println("stack3 overflow");
		} else {
			sum3 += data3;
			stack3[top3] = data3;
			top3++;
		} 
	}

	public int getMaximumHeight(){
		if((sum1 == sum2) && (sum1 == sum3)){
			return sum1;
		}
		int sum = getStack1Stack2Equal();

		while(!isEmpty(stack3,top3)) { 
			if(sum == sum3) {
				return sum;
			} else if(sum < sum3){
				popStack3();
			} 
		}  
		return -1;
	}
	public int getStack1Stack2Equal() { 
		while(!isEmpty(stack1,top1) || !isEmpty(stack2,top2)) {
			if(sum1 == sum2) {
				return sum1;
			}
			if(sum1 < sum2){
				popStack2();
			} else {
				popStack1();
			} 
		}  
		return -1;
	}

	public boolean isEmpty(int[] stack, int top) {
		if(top<=0){
			return true;
		}
		else return false;
	}

	public int popStack1() {
		if(top1>0) {
			top1--;
			int temp1 = stack1[top1];
			sum1 -= temp1;

			return sum1;
		} else {
			System.out.println("Stack1 underflow");
		}
		return sum1;
	}

	public int popStack2() {
		if(top2>0) {
			top2--;
			int temp2 = stack2[top2];
			sum2 -= temp2;
			return sum2;
		} else{
			System.out.println("Stack2 underflow");
		}
		return sum2;
	}


	public int popStack3() {
		if(top3>0){
			top3--;
			int temp3 = stack3[top3];
			sum3 -= temp3;  
			return sum3;
		} else {
			System.out.println("Stack3 underflow");
		}
		return sum3;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1[] = new int[n1];
		EqualStack sol = new EqualStack(n1,n2,n3);
		for(int h1_i=0; h1_i < n1; h1_i++){
			h1[h1_i] = in.nextInt();
			//sol.pushStack1(h1[h1_i]);
		}
		int h2[] = new int[n2];
		for(int h2_i=0; h2_i < n2; h2_i++){
			h2[h2_i] = in.nextInt();
			//sol.pushStack2(h2[h2_i]);
		}
		int h3[] = new int[n3];
		/*for(int h3_i=0; h3_i < n3; h3_i++){
			h3[h3_i] = in.nextInt();
			//sol.pushStack3(h3[h3_i]);
		}
		 for(int i =0;i<n1;i++){
	          sol.pushStack1(h1[i]);
	      }
	      
	      for(int i =0;i<n2;i++){
	          sol.pushStack2(h2[i]);
	      }
	      
	      for(int i =0;i<n3;i++){
	          sol.pushStack3(h3[i]);
	      }
		System.out.println(sol.getMaximumHeight());*/
		
		
		int i,j,k;
	    i = n1-1;
	    j = n2-1;
	    k = n3-1;
	    while(i>=0 && j>=0 && k>=0){
	        if(h1[i]==h2[j] && h2[j]==h3[k]){
	            System.out.println(h1[i]);
	            //return 0;
	        }
	        while(h1[i]>h2[j] || h1[i]>h3[k]){
	            i--;
	        }
	        while(h2[j]>h1[i] || h2[j]>h3[k]){
	            j--;
	        }
	        while(h3[k]>h2[j] || h3[k]>h1[i]){
	            k--;
	        }
	    }
	    System.out.println(0);
	}
}
