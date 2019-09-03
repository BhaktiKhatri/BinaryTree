package BinaryTrees;

/**
 * 9.16 Compute the right sibling tree
 * Page 144
 * WAP that takes a perfect binary tree, and sets each node's level-next field to the node on its right, if one exists
 * @author NisuBhakti
 *
 */

public class ComputeRightSiblingTree {
	
	BinaryTreeNode root;

	public static void constructRightSibling(BinaryTreeNode root) {
		BinaryTreeNode leftStart = root;
		System.out.println("leftStart: "+leftStart.data);
		
		while(leftStart != null && leftStart.left != null) {
			System.out.println("leftStart: "+leftStart.data+" leftStart.left: "+leftStart.left.data);
			
			populateLowerLevelNextField(leftStart);
			leftStart = leftStart.left;
		}
	}

	public static void populateLowerLevelNextField(BinaryTreeNode startNode) {
		BinaryTreeNode curr = startNode;
		
		while(curr != null) {
		
			System.out.println("curr: "+curr.data+" curr.right: "+curr.right.data);
			curr.left.next = curr.right;
			
			if(curr.next != null) {
				System.out.println("curr.next: "+curr.next.data+" curr.next.left: "+curr.next.left);
				curr.right.next = curr.next.left;
			}
			
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		ComputeRightSiblingTree tree = new ComputeRightSiblingTree();
		
//		tree.root = new BinaryTreeNode(3);
//		tree.root.left = new BinaryTreeNode(9);
//		tree.root.right = new BinaryTreeNode(20);
//		tree.root.right.left = new BinaryTreeNode(15);
//		tree.root.right.right = new BinaryTreeNode(7);
//		
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		tree.root.right.left = new BinaryTreeNode(6);
		tree.root.right.right = new BinaryTreeNode(7);
		
		constructRightSibling(tree.root);
		System.out.println();
	}

}
