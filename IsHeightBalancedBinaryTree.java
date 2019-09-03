package BinaryTrees;

/**
 * Page 127
 * WAP that takes as input the root of a binary tree and checks whether the tree is height balanced.
 * A Binary tree is said to be height balanced if for each node in the tree, the difference in the height of its left and right sub trees is at most one. 
 * A perfect binary tree is height balanced as it is a complete binary tree but not vice versa.
 * Program tree example from:https://leetcode.com/problems/balanced-binary-tree/description/
 * @author NisuBhakti
 * Time Complexity is the same as of postorder traversal: O(n); Space complexity is O(h)
 */

class BalanceStatusWithHeight {
	public boolean balanced;
	public int height;
	
	public BalanceStatusWithHeight(boolean balanced, int height) {
		this.balanced = balanced;
		this.height = height;
	}
}

public class IsHeightBalancedBinaryTree {
	
	BinaryTreeNode root;

	public static boolean isBalanced(BinaryTreeNode root) {
		return checkBalanced(root).balanced;
	}
	
	public static BalanceStatusWithHeight checkBalanced(BinaryTreeNode root) {
		if(root == null)
			return new BalanceStatusWithHeight(true, -1);	//Base Case
		
		System.out.println("root: "+root.data);
		
		BalanceStatusWithHeight leftResult = checkBalanced(root.left);
		if(!leftResult.balanced)
			return leftResult;								//Left subtree is not balanced
		
		BalanceStatusWithHeight rightResult = checkBalanced(root.right);
		if(!rightResult.balanced)
			return rightResult;								//Right subtree is not balanced
		
		boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
		int height = Math.max(leftResult.height, rightResult.height) + 1;
		
		return new BalanceStatusWithHeight(isBalanced, height);
	}
	
	public static void main(String[] args) {
		IsHeightBalancedBinaryTree tree = new IsHeightBalancedBinaryTree();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(2);
		tree.root.left.left = new BinaryTreeNode(3);
		tree.root.left.right = new BinaryTreeNode(3);
		tree.root.left.left.left = new BinaryTreeNode(4);
		tree.root.left.left.right = new BinaryTreeNode(4);
		
		System.out.println(isBalanced(tree.root));
	}

}
