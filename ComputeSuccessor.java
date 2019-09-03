package BinaryTrees;

/**
 * Compute the successor
 * Page 137
 * Design an algorithm that computes the successor of a node in a binary tree. Assume that each node stores its parent.
 * Since the number of edges followed can not be more than the tree height, the time complexity is O(h), where h is the height of the tree.
 */

public class ComputeSuccessor {

	BinaryTreeNode root;
	
	public static BinaryTreeNode findSuccessor(BinaryTreeNode root) {
		BinaryTreeNode curr = root;
		
		System.out.println("root: "+root.data);
		
		//Find the leftmost element in the right subtree
		if(curr.right != null) {
			System.out.println("curr.right: "+curr.right.data);
			curr = curr.right;
			System.out.println("curr: "+curr.data);
			while(curr.left != null) {
				System.out.println("curr.left: "+curr.left.data);
				curr = curr.left;
				System.out.println("curr: "+curr.data);	
			}
			return curr;
		}
		
		//Find the closest ancestor whose left subtree contains node
		//If the node is the parent's right child then we have already visited the parent. We can determine the next visited node by iteratively following 
		//parents and stopping when we move up from a left child; eg 1 is the successor of 8
		while(curr.parent != null && curr.parent.right == curr) {
			System.out.println("curr: "+curr.data+" curr.parent: "+curr.parent.data+" curr.parent.right: "+curr.parent.right.data);
			curr = curr.parent;
		}
		
		System.out.println("curr: "+curr.data+" curr.parent: "+curr.parent.data);
		//A return value of null means node does not have successor i.e. it is the rightmost node in the tree
		//If the node is the parent's left child, parent will be the next node we visit and hence is its successor; eg 8 is successor of 9
		return curr.parent;	
	}
	
	public static void main(String[] args) {
		ComputeSuccessor tree = new ComputeSuccessor();
		
		/*
		 					   1
		 					 /   \
		 					2      3
		 				  /  \     / \
		 				 4    8    5  6
		 				     /    /
		 				    9     7
		 */
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.left.right = new BinaryTreeNode(8);
		tree.root.left.right.left = new BinaryTreeNode(9);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.right.left = new BinaryTreeNode(5);
		tree.root.right.left.left = new BinaryTreeNode(7);
		tree.root.right.right = new BinaryTreeNode(6);
		
		tree.root.left.parent = tree.root;
		tree.root.left.left.parent = tree.root.left;
		tree.root.right.parent = tree.root;
		tree.root.right.left.parent = tree.root.right;
		tree.root.right.left.left.parent = tree.root.right.left;
		tree.root.right.right.parent = tree.root.right;
		tree.root.left.right.parent = tree.root.left;
		tree.root.left.right.left.parent = tree.root.left.right;
		
		tree.root = findSuccessor(tree.root);
		if(tree.root != null) 
			System.out.println(tree.root.data);
		else
			System.out.println("No successor found");
	}

}
