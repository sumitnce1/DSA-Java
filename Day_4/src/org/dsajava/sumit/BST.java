package org.dsajava.sumit;

import java.util.LinkedList;
import java.util.Queue;

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
			System.out.print(root.val+" ");
			inorderTraversal(root.right);
		}
	}
	public void preorder() {
		preorderTraversal(root);
	}

	private void preorderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void postorder() {
		postorderTraversal(root);
	}

	private void postorderTraversal(TreeNode root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.val + " ");
		}
	}
	
	public static void bfs(TreeNode root) {
		if (root == null) {
			return;			
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();  //dequeue
			System.out.print(current.val+" ");
			
			if (current.left!=null) {
				queue.add(current.left);				
			}
			if (current.right != null) {
				queue.add(current.right);
			}
			
		}
	}
	
	public static void dfs(TreeNode root) {
		if (root ==null) {
			return;
		}
		System.out.print(root.val+" ");	
		dfs(root.left);
		dfs(root.right);
	}

	public static void main(String[]args) {
		BST tree = new BST();
		TreeNode root = new TreeNode(50);
		/*
		 * tree.insert(25); tree.insert(10); tree.insert(8); tree.insert(15);
		 * tree.insert(40); tree.insert(36); tree.insert(50); tree.insert(28);
		 * tree.insert(20); tree.insert(1); tree.insert(65);
		 */
		
		tree.insert(50);
		tree.insert(20);
		tree.insert(66);
		tree.insert(12);
		tree.insert(80);
		tree.insert(28);
		tree.insert(55);
		tree.insert(63);
		tree.insert(26);
		tree.insert(16);
		tree.insert(52);
		tree.insert(70);
		System.out.println("Inorder Traversal:");
        tree.inorder();
        
        System.out.println("\nPreorder Traversal:");
        tree.preorder();
        System.out.println("\n");
        System.out.println("\nPostorder Traversal:");
        tree.postorder();
        System.out.println("\n");
        System.out.println("\nBreadth-First Search:");		
		bfs(tree.root);
		System.out.println("\n");
		System.out.println("Depth First Search Algorithm: ");
		dfs(tree.root);
		System.out.println();
		/*
		 * tree.delete(15); tree.delete(2 5); System.out.println("\nPre-Order :");
		 * tree.inorder();
		 */
	}
}