package com.stalele.ds;

public class QueueWithLinkedList {
	//remove the element from the queue
	private Node head = null; 
	
	/**
	 * add element at the end of the queue. If you do not use tail pointer then complexity is o(n) 
	 * because u will have to iterate till end of the linked list. With tail pointer, u can achieve addition in o(1)
	 */
	private Node tail = null; 
	
	public boolean isEmpty() {
		return head == null;
		
	}
	
	public int peek() {
		if(head == null) {
			throw new RuntimeException("Queue is empty");
		} else {
			int temp = head.data;
			display();
			System.out.println("Peek element in Queue" + temp);;
			return temp;
		}
	}
	//some people also call this as enqueue
	public void add(int data) {
		Node node = new Node(data);
		if(head == null && tail == null) { 
			head = tail = node;
			display();
			return;
		}
		tail.next = node;
		tail = node;
		display();
	}
	//some people also call this as dequeue
	public int remove() {
		if(head!=null){
			int temp = head.data;
			head = head.next;
			display();
			return temp;
		} else{
			throw new RuntimeException("Queue is empty");
		}
	}
	
	public void display(){
		Node node = head;
		while(node!=null){
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[]args) {
		QueueWithLinkedList queue = new QueueWithLinkedList();
		queue.add(10);
//		queue.remove();
		queue.add(100);
		queue.add(200);
		queue.add(300);
		queue.add(400);
		queue.peek();
		queue.add(500);
		queue.add(600);
		queue.add(700);
		queue.add(800);
		queue.add(900);
		queue.add(1000);
		queue.peek();
		queue.add(2000);

		queue.remove();
		queue.remove();
		queue.remove();
		queue.peek();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.peek();
		queue.remove();
	}

}
