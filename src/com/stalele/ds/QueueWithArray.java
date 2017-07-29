package com.stalele.ds;

public class QueueWithArray {
	int capacity = 5;
	private int[] data = new int[capacity];
	int size = 0;
	int readIndex = 0;
	int writeIndex = 0;
	//Queue empty condition if readIndex = writeIndex = 0;
	//Queue full condition if readIndex = writeIndex and ! = 0
	//Queue - empty, readIndex = 0, writeIndex = 0; 
	//10, readIndex = 0, writeIndex = 1;
	//10-> 20, readIndex = 0, writeIndex = 2
	//10->20->30, readIndex = 0, writeIndex = 3
	//10->20->30->, readIndex = 0, writeIndex = 4
	//10->20->30->40, readIndex = 0, writeIndex = 5
	//**REmove 
	//10->20->30->40->50, temp =10, data[readIndex] = 0,readIndex = 1, writeIndex = 0, return 10
	//20->30, readIndex = 2, writeIndex = 0, return 20
	//30, readIndex = 3, writeIndex = 0, return 30
	//remove 30->40, readIndex = 
	public void add(int data) {
		if(isFull()) {
			throw new RuntimeException("Queue is full");
		} else{
			this.data[writeIndex] = data;
			writeIndex =  (writeIndex+1)%capacity;
			size++;
			display();
			System.out.println("ReadIndex: " +  readIndex + "|| WriteIndex: " + writeIndex);

		}
	}

	public boolean isFull() {
		return(size == capacity);
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	//Queue = empty
	//10->20->30, temp =10, data[readIndex] = 0,readIndex = 1, writeIndex = 3, return 10
	//20->30, readIndex = 2, writeIndex = 3, return 20
	//30, readIndex = 3, writeIndex = 3, return 30
	//empty
	public int remove(){
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		} else{ 
			int temp = data[readIndex];
			data[readIndex] = 0;
			readIndex =  (readIndex+1)%capacity;
			size--;
			display();
			System.out.println("After removing ReadIndex: " +  readIndex + "|| WriteIndex: " + writeIndex);
			return temp;
		}
	}

	public int peek() {
		if(isEmpty()){
			throw new RuntimeException("Queue is empty");
		}else {
			System.out.println("Peek element in Queue" + data[readIndex]);
			return data[readIndex];
		} 
	}		

	public void display() {
		for(int d: data){
			System.out.print(d + "->");
		}
		System.out.println();
	}

	public static void main(String[]args) {
		QueueWithArray queue = new QueueWithArray();
		queue.add(100);
		queue.add(200);
		queue.add(300);
		queue.peek();
		queue.remove();
		queue.remove();
		queue.add(400);
		queue.add(500);
		queue.add(600);
		queue.add(700);
		//queue.add(800);
		queue.peek();
		//queue.add(2000);
		queue.remove();
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
	}


}
