package com.stalele.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Header1_1Impl;

public class BinarySearchTreeOperation {

	/*
	 * 		 10
	 * 		/  \
	 * 	   5	20
	 * 	   /\   /\
	 * 	  3  9 15 25
	 */
	//Left node < Root node < Right node

	public class TreeNode {
		int data;
		TreeNode left, right, parent;

		public TreeNode(int value) {
			this.data = value;
		}
	}

	TreeNode root;

	public void insert(int value){
		TreeNode newNode = new TreeNode(value);
		if(root == null){
			root = newNode;
			return;
		} 

		TreeNode current = root;

		while(true) {
			TreeNode parent = current;	
			if(value <= current.data) {
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	//time complexity depends upon depth of the node. 
	public TreeNode find(int value){
		if(root.data == value) {
			return root;
		}

		TreeNode current = root;

		while(current.data!=value){
			if(value <= current.data){
				current = current.left;
			} else {
				current = current.right;
			}
			if(current == null){
				return null;
			}
		}

		return current;

	}




	public void inOrderTraversalWithStack() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(true) {
			while(current!=null) {
				stack.push(current);
				current =current.left;
			}
			if(stack.isEmpty()){
				return;
			}
			current = stack.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}

	public void preOrderWithStack() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		while(true) {
			while(current!=null){
				System.out.print(current.data+ " ");
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()){
				return;
			}
			current = stack.pop();
			current = current.right;
		}
	}

	/**
	 * We have seen how we do inorder and pre­order tra­ver­sals with­out recur­sion using Stack, But post order tra­ver­sal will be dif­fer­ent and slightly more com­plex than other two. 
	 * Rea­son is post order is non-tail recur­sive ( The state­ments exe­cute after the recur­sive call).
	 * If you just observe here, pos­torder tra­ver­sal is just reverse of pre­order tra­ver­sal
	 * PreOrder traversal(10 5 3 1 4 9 20 15 13 17 25 30 if we tra­verse the right node first and then left node.) So idea is fol­low the same tech­nique as pre­order tra­ver­sal and instead of print­ing it, push it to the another Stack so that they will come out 
	 * in reverse order (LIFO). At the end just pop all the items from the sec­ond Stack and print it.
	 */

	public void postOrderWithStack() {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		if(root!=null){
			stack1.push(root);
		} else return;
		while(!stack1.isEmpty()) {
			TreeNode current = stack1.pop();
			stack2.push(current);
			if(current.left!=null){
				stack1.push(current.left);
			}
			if(current.right!=null){
				stack1.push(current.right);
			}
		}
		while(!stack2.isEmpty()){
			System.out.println(stack2.pop().data + " ");
		}
	}
	/**
	 * USe Queue - 
	 * Here we will use NULL as a marker at every level, so when­ever we encounter null, we will incre­ment the height by 1.
	 * @return
	 */

	public int height(){
		if(root == null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList();
		TreeNode current  = root;
		int height = 0;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			current = queue.remove();
			if(current==null){
				if(!queue.isEmpty()){
					queue.add(null);
				}
				height++;
			} else{
				if(current.left!=null){
					queue.add(current.left);
				}
				if(current.right!=null) {
					queue.add(current.right);
				}
			}
		}
		return height;
	}
	
	public void levelOrderQueue(){
 		Queue<TreeNode> q = new LinkedList();
 		int levelNodes =0; 
		if(root==null){
			return;
		}
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
				TreeNode current = q.remove();
				System.out.print(" " + current.data);
				if(current.left!=null) q.add(current.left);
				if(current.right!=null) q.add(current.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}

	public static void main(String args[]) 
	{

		BinarySearchTreeOperation tree = new BinarySearchTreeOperation();
		tree.insert(10);//add root
		tree.insert(20);
		tree.insert(5);
		tree.insert(3);
		tree.insert(9);
		tree.insert(1);
		tree.insert(4);
		tree.insert(15);
		tree.insert(25);
		tree.insert(13);
		tree.insert(17);
		tree.insert(30);
		System.out.println("InOrder traversal");
		tree.inOrderTraversalWithStack();
		System.out.println("PreOrder traversal");
		tree.preOrderWithStack();
		System.out.println("\nPostOrder traversal");
		tree.postOrderWithStack();
		System.out.println("Height of the tree is : " + tree.height());
		System.out.println("Level of of the tree is : ");
		tree.levelOrderQueue();
	}
}



