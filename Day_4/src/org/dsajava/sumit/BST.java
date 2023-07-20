package org.dsajava.sumit;

public class BST {

	private TreeNode root;
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			val = data;
			left = null;
			right = null;
		}
	}
	public BST() {
		this.root = null;
	}
	
	public void insert (int val) {
		root = insertRec(root, val);
	}
	
	private TreeNode insertRec(TreeNode root, int val) {
		if (root==null) {
			System.out.println("Node Added: "+val);
			return new TreeNode(val);
		}
		if(val<root.val) {
			root.left = insertRec(root.left, val);
		}
		else {
			root.right=insertRec(root.right,val);
		}
		return root;
	}
	
	public void delete (int val) {
		root = deleteRec(root, val);
	}
	
	private TreeNode deleteRec(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if(val<root.val) {
			root.left=deleteRec(root.left,val);
		}
		else if(val>root.val) {
			root.right=deleteRec(root.right,val);
		}
		else {
			if(root.left==null) {
				return root.right;
				
			}else if(root.right == null) {
				return root.left;
			}
			root.val = findMin (root.right);
			root.right = deleteRec(root.right, root.val);
		}
		return root;
	}
	
	public int findMin(TreeNode root) {
		int minVal = root.val;
		while(root.left != null) {
			minVal = root.left.val;
			root= root.left;
		}
		return minVal;
	}
	
	public void inorder() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(TreeNode root) {
		if (root!=null) {
			inorderTraversal(root.left);
			System.out.println(root.val+" ");
			inorderTraversal(root.right);
		}
	}
	
	public static void main(String[]args) {
		BST tree = new BST();
		tree.insert(25);
		tree.insert(10);
		tree.insert(8);
		tree.insert(15);
		tree.insert(40);
		tree.insert(36);
		tree.insert(50);
		tree.insert(28);		
		tree.insert(20);
		tree.insert(1);
		tree.insert(65);
		tree.inorder();
	}
}