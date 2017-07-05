package com.stalele.ds;

public class CheckCycleInLinkedList {
	
	public boolean hasCycle(Node head){
		if(head == null)
			return false;
	Node slow = head;
	Node fast = head;
	while(fast!=null && slow!=null){
		if(fast == slow){
			return true;
		}
		fast = fast.next.next;
		slow = slow.next;
	}
		return false;
		
	}

}
