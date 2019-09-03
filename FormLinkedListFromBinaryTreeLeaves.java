package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

/**
 * 9.14 Form a LinkedList from the leaves of a Binary Tree
 * Given a binary tree, compute a linked list from the leaves of the binary tree
 * Page 142
 * @author NisuBhakti
 *
 */

public class FormLinkedListFromBinaryTreeLeaves {

	BinaryTreeNode root;
	
	public static List<BinaryTreeNode> createListOfLeaves(BinaryTreeNode root) {
		List<BinaryTreeNode> leaves = new LinkedList<>();
		System.out.println("root: "+root.data);
		
		addLeavesLeftToRight(root, leaves);
		return leaves;
	}
	
	public static void addLeavesLeftToRight(BinaryTreeNode root, List<BinaryTreeNode> leaves) {
		if(root != null) {
			System.out.println("root: "+root.data+" leaves: "+leaves);
			if(root.left == null && root.right == null) {
				leaves.add(root);
			}
			else {
				System.out.println("root.left: "+root.left.data+" root.right: "+root.right.data);
				addLeavesLeftToRight(root.left, leaves);
				addLeavesLeftToRight(root.right, leaves);
			}
		}
	}
	
	public static void main(String[] args) {
		FormLinkedListFromBinaryTreeLeaves tree = new FormLinkedListFromBinaryTreeLeaves();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		System.out.println(createListOfLeaves(tree.root));
	}

}