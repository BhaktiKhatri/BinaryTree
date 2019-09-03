package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 9.13 Reconstruct a binary tree from a preorder traversal with markers
 * Design an algorithm for reconstructing a binary tree from a preorder traversal visit sequence that uses null to mark empty children
 * Page 141
 * @author NisuBhakti
 * Time Complexity is O(n) where n is the number of nodes in the tree
 */

public class BinaryTreeFromPreorderWithMarkers {
	
	//Global variable, tracks current subtree	
	public static Integer subtreeIdx;
	
	public static BinaryTreeNode reconstructPreorder(List<Integer> preorder) {
		subtreeIdx = 0;
		System.out.println("preorder: "+preorder);
		return reconstructPreorderSubtree(preorder);
	}
	
	public static BinaryTreeNode reconstructPreorderSubtree(List<Integer> preorder) {
		
		Integer subtreeKey = preorder.get(subtreeIdx);
		System.out.println("subtreeKey: "+subtreeKey+" subtreeIdx: "+subtreeIdx);
		
		++subtreeIdx;
		System.out.println("subtreeIdx: "+subtreeIdx);
		
		if(subtreeKey == null)
			return null;
		
		BinaryTreeNode root = new BinaryTreeNode(subtreeKey);
		System.out.println("root: "+root.data);
		
		BinaryTreeNode leftSubtree = reconstructPreorderSubtree(preorder);
		BinaryTreeNode rightSubtree = reconstructPreorderSubtree(preorder);
		
		if(leftSubtree != null && rightSubtree != null)
			System.out.println("leftSubtree: "+leftSubtree.data+" rightSubtree: "+rightSubtree.data);
		else
			System.out.println("leftSubtree: "+leftSubtree+" rightSubtree: "+rightSubtree);
		
		root.left = leftSubtree;
		root.right = rightSubtree;
		
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> preorder = new ArrayList<>();
		preorder.add(3);
		preorder.add(9);
		preorder.add(null);
		preorder.add(null);
		preorder.add(20);
		preorder.add(15);
		preorder.add(null);
		preorder.add(null);
		preorder.add(7);
		preorder.add(null);
		preorder.add(null);
		
		BinaryTreeNode root = reconstructPreorder(preorder);
		
		System.out.println("      "+root.data);
		System.out.println("     /"+" \\");
		System.out.println("    "+root.left.data+"  "+root.right.data);
		System.out.println("       /"+" \\");
		System.out.println("      "+root.right.left.data+"  "+root.right.right.data);

	}

}
