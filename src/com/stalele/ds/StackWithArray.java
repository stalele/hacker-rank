package com.stalele.ds;

public class StackWithArray {

	private int size;

	private int[] data;

	private int top = 0;

	public int getTop(){
		System.out.println("Top value is " + top);
		return top;
	}

	public StackWithArray(int size) {
		this.size = size;
		data = new int[size];
		display();
	}

	public int pop() {
		if(top <= 0){
			System.out.println("Stack underflow");
		}else {
			top--;
			int temp = data[top];
			data[top] = 0;
			display();
			return temp;
		}		
		return 0;
	}

	public int getTopElement() {
		if(top >= size){
			System.out.println("Top element is" + data[size-1]);
		}  else if(top > 0){
			int temp =top;
			temp--;
			System.out.println("Top element is" + data[temp]);
			return data[temp];
		}
		return 0;
	}

	private boolean isStackEmpty() {
		if(top < 0) {
			System.out.println("Stack is empty!");
			return true;
		}
		return false;
	}

	private boolean isStackFull() {
		if(top >= size){
			System.out.println("Stack is full!");
			return true;
		}
		return false;
	}

	public boolean push(int x) {
		if(top>=size){
			System.out.println("Stack overflow");
		}else{
			data[top] = x;
			top++;
			display();
			return true;
		}
		return false;
	}

	public void display() {
		for(int i : data){
			System.out.print(i + "||");
		}

		System.out.println();
	}

	public static void main(String[]args) {
		StackWithArray stack = new StackWithArray(10);
		stack.getTop();
		stack.getTopElement();
		stack.push(10);
		//stack.getTop();
		stack.pop();
		//stack.getTop();
		stack.push(100);
		//stack.getTop();
		stack.push(200);
		//stack.getTop();
		//stack.getTop();
		stack.push(300);
		stack.push(400);
		stack.push(500);
		stack.push(600);
		stack.push(700);
		stack.push(800);
		stack.push(900);
		stack.push(1000);
		stack.getTop();
		stack.getTopElement();
		stack.push(20000);

		//stack.getTopElement();
		//stack.getTop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.getTop();
		stack.getTopElement();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.getTop();
		stack.getTopElement();
		stack.pop();
		stack.getTop();
		stack.getTopElement();

	}

}
