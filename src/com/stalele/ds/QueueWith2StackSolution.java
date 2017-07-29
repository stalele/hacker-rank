package com.stalele.ds;

import java.util.Stack;

public class QueueWith2StackSolution {
	//https://www.hackerrank.com/challenges/queue-using-two-stacks
	//during adding the element, push into stack1,during removing the element check if stack2 is empty, then only move elements from stack1 to stack2 otherwise, you can pop 
	//the element and return it,  
	//In this solution, Push operation takes o(1), pop and print operation is expensive o(n)

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	//some people also call this as enqueue
	public void add(int data) {
		stack1.push(data);
		display();
	}
	//some people also call this as dequeue
	public int remove() {
		moveFromStack1ToStack2(); 
		return stack2.pop();
	}

	private void moveFromStack1ToStack2() {
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}



	public void display(){
		if(stack1.isEmpty()){
			throw new RuntimeException("Queue is empty");
		} else {
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			while(!stack2.isEmpty()){
				int data = stack2.pop();
				System.out.print(data + "->");
				stack1.push(data);
			}
			System.out.println();
		}
	}
	public int peek(){
		moveFromStack1ToStack2();
		return stack2.peek();
	}


	public static void main(String[]args) {

		QueueWith2StackSolution queue = new QueueWith2StackSolution();
		queue.add(100);
		queue.add(200);
		queue.add(300);
		queue.remove();
		queue.remove();
		queue.add(400);
		queue.add(500);
		queue.add(600);
		queue.add(700);
		//queue.add(800);
		//queue.add(2000);
		//queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		//	queue.remove();
		queue.add(3000);
		queue.add(4000);
		queue.add(5000);
		queue.add(6000);
		queue.add(7000);
		queue.add(8000);
		queue.remove();
	}

}
