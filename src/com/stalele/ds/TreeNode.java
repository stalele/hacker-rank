package com.stalele.ds;

public class TreeNode {
	/*
	 * 		 10
	 * 		/  \
	 * 	   5	20
	 * 	   /\   /\
	 * 	  3  9 15 25
	 */
	//Left node < Root node < Right node

	TreeNode left, right;
	int data;

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode(int value) {
		this.data = value;
	}

	public void insert(int value){
		if(value <= data) {
			if(left == null) {
				left = new TreeNode(value);
			} else {
				left.insert(value);
			}
		} else if(right == null) {
			right = new TreeNode(value);
		} else {
			right.insert(value);
		}
	}
	
	
	public static TreeNode insert(TreeNode root, int data) {
        if(root == null){
            return new TreeNode(data);
        }
        else {
            TreeNode cur;
            if(data <= root.data){
                cur = insert(root.getLeft(), data);
                root.left = cur;
            }
            else{
                cur = insert(root.getRight(), data);
                root.right = cur;
            }
            return root;
        }
    }

	public boolean contains(int value){
		if(value == data) {
			return true;
		} else if(value < data){
			if(left == null){
				return false;
			}else{
				left.contains(value);
			}
		} else if(right == null){
			return false;
		} else {
			return right.contains(value);
		}
		return false;
	}
	
	public int height(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight,rightHeight) + 1;
	}
	
	
	/**
	 * InOrder, PreOrder and Postorder are DFS algorithms
	 */
	public void inOrderTraversalRecursive() {
		if(left!=null){
			left.inOrderTraversalRecursive();
		} 
		System.out.println(data);
		
		if(right!=null) {
			right.inOrderTraversalRecursive();
		} 
	}
	
	public void preOrderTraversalRecursive(){
		System.out.println(data);
		if(left!=null){
			left.preOrderTraversalRecursive();
		}
		if(right!=null) {
			right.preOrderTraversalRecursive();
		}
	}
	
	public void postOrderTraversalNonRecursive(){
		
		if(left!=null){
			left.postOrderTraversalNonRecursive();
		}
		if(right!=null) {
			right.postOrderTraversalNonRecursive();
		}
		System.out.println(data);
	}
	
	public static void main(String args[]) 
	{
		TreeNode tree = new TreeNode(10);
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
		tree.inOrderTraversalRecursive();
		System.out.println("PreOrder traversal");
		tree.preOrderTraversalRecursive();
		System.out.println("PostOrder traversal");
		tree.postOrderTraversalNonRecursive();
		System.out.println("Height of the tree is: " + tree.height(tree));
	}
	
}