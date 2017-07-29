package com.stalele.ds;

import java.util.Scanner;

public class BalancedBracket {

	private int top = 0;
	private char[] stack;
	private int size;

	public BalancedBracket(int size){
		stack = new char[size];
		this.size = size;
		top = 0;
	}

	public boolean isBalanced(String operators) {
		char []ops = operators.toCharArray();

		for(int i = 0; i < ops.length; i++){
			char operator = ops[i];
			char topChar = peek();
			switch(operator){
			case '{': push(operator);
			break;
			case '[': push(operator);
			break;
			case '(': push(operator);
			break;
			case '}': 
				if(topChar == '{') {
					pop();  
				} else return false;

				break;
			case ']': 
				if(topChar == '[') {
					pop();  
				} else return false;
				break;
			case ')': 
				if(topChar == '(') {
					pop();  
				} else return false;
				break;
			}
		}

		if(!isEmpty()) {
			return false;
		}

		return true;

	}

	public void push(char operator){
		if(top >= size){
			System.out.println("stack overflow");
		} else {
			stack[top] = operator;
			top ++;
		}   
	}

	public void pop(){
		if(top <= 0){
			System.out.println("stack underflow");
		} else {
			top--;
			stack[top] = 'X';
		}   
	}

	public void display() {
		for(int i =0;i < size;i++) {
			System.out.print(stack[i] + "->");
		}
		System.out.println();
	}

	public char peek() {
		char op = 0;
		if(top >= size){
			op = stack[size - 1];
		}
		else if(top > 0){
			int temp = top;
			temp--;
			op = stack[temp]; 
		}
		return op;
	}

	public boolean isEmpty() {
		if(top <= 0){
			return true;
		} 
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String []operators = new String[t];
		for(int a0 = 0; a0 < t; a0++){
			String s = in.next();
			operators[a0] = s;
		}
		for(int a0 = 0; a0 < t; a0++) {
			BalancedBracket sol = new BalancedBracket(operators[a0].toCharArray().length);
			System.out.println(sol.isBalanced(operators[a0]) ? "YES" : "NO") ;
		}    
	}
}
