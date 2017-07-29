package com.stalele.ds;

public class LinkedList {
	Node head;

	//O(n)
	public void append(int data){
		if(head==null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = new Node(data);
	}

	//O(1)
	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.data = data;
		newHead.next = head;
		head = newHead;
	}

	//O(n)

	public void deleteWithValue(int data) {
		if(head == null) 
			return;
		if(head.data == data) {
			head = head.next;
		}

		Node current = head;
		while(current.next!=null){
			if(current.next.data == data){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}


	Node DeleteAtPosition(Node head, int position) {
		// Complete this method
		if(head == null){
			return null;
		}
		if(position  == 0){
			head = head.next;
			return head;
		}
		int counter = 1;
		Node prev = head;
		Node current = head.next;


		while(current!=null){
			if(position == counter){
				prev.next = current.next;
				current.next = null;
				return head;
			}
			counter++;
			prev = current;
			current = current.next;

		}
		return head;
	}

	Node Reverse(Node head) {
		if(head == null){
			return null;
		}
		Node current = head;
		Node prev = null;
		Node next = current.next;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	int CompareLists(Node headA, Node headB) {
		// This is a "method-only" submission. 
		// You only need to complete this method 
		if(headA == null || headB == null){
			return 0;
		}

		Node currentA = headA;
		Node currentB = headB;
		int lengthA =0;
		int lengthB =0;
		while(currentA!=null && currentB!=null){
			if(currentA.data!=currentB.data){
				return 0;
			}
			else{
				currentA = currentA.next;
				currentB = currentB.next;
				lengthA++;
				lengthB++;
			}
		}
		if((currentA == null && currentB!=null)||(currentA!=null && currentB==null)){
			return 0;
		}

		if(lengthA == lengthB){
			return 1;
		}
		return 0;  
	}

	
	//working with dummy head
	Node mergeListsWithDummyVariable(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
		if (headA == null && headB == null) return null;
		else if (headA == null) return headB;
		else if (headB == null) return headA;

	  Node head = new Node(0);
	  Node temp = head;
	  Node currentA = headA;
	  Node currentB = headB;
	  
	  while(currentA != null && currentB != null){
	    if(currentA.data <  currentB.data) {
	      temp.next = currentA;
	      currentA = currentA.next;
	    } else {
	      temp.next = currentB;
	      currentB = currentB.next;
	    }
	    temp = temp.next;
	  }
	  
	  if(currentA!=null){
	    temp.next = currentA;
	  }
	  
	  if(currentB!=null){
	    temp.next = currentB;
	  }
	  head = head.next;
	  return head;

	}
	
	Node mergeListsRecursive(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
	  if (headA == null)
	        return headB;
	    else if (headB == null)
	        return headA;
	    else if (headA.data <= headB.data){
	        headA.next = mergeListsRecursive(headA.next, headB);
	        return headA;
	    } else {
	        headB.next = mergeListsRecursive(headA, headB.next);
	        return headB;
	    }

	}

}


