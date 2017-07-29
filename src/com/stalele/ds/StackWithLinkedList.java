package com.stalele.ds;

import javax.management.RuntimeErrorException;

public class StackWithLinkedList {


	private Node top; //this is nothing but the head element in the linked list

	public boolean isEmpty() {
		return top == null;
	}

	public int peek(){
		if(top!=null){
			return top.data;
		} else throw new RuntimeException("stack underflow");

	}

	public void push (int data){
		Node node = new Node(data);
		node.next = top;
		top = node;
		display();
	}

	public int pop() {
		if(top == null){
			throw new RuntimeException("stack underflow");
		}
		else {
			int temp = top.data;
			top = top.next;
			display();
			return temp;
		}

	}
	
	public void display() {
		if(top==null){
			throw new RuntimeException("stack underflow");
		}
		Node current = top;
		while(current!=null){
			System.out.print(current.data + "||");
			current = current.next;
		}
		System.out.println();
		
	}
	
	public static void main(String[]args) {
		StackWithLinkedList stack = new StackWithLinkedList();
		stack.push(10);
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		stack.push(600);
		stack.push(700);
		stack.push(800);
		stack.push(900);
		stack.push(1000);
		stack.peek();
		stack.push(20000);

		stack.pop();
		stack.pop();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.peek();
		stack.pop();
	}
}
