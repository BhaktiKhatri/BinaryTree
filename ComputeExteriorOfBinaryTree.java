package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

/**
 * 9.15 Compute the exterior of a Binary Tree
 * Page 143
 * WAP that computes the exterior of a Binary Tree
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class ComputeExteriorOfBinaryTree {

	BinaryTreeNode root;
	
	public static List<BinaryTreeNode> exteriorBinaryTree(BinaryTreeNode root) {
		List<BinaryTreeNode> exterior = new LinkedList<>();
		
		if(root != null) {
			System.out.println("root: "+root.data);
			exterior.add(root);
			exterior.addAll(leftBoundaryAndLeaves(root.left, true));
			exterior.addAll(rightBoundaryAndLeaves(root.right, true));
		}
		
		return exterior;
	}
	
	//Computes the nodes from 
	public static List<BinaryTreeNode> leftBoundaryAndLeaves(BinaryTreeNode subtreeRoot, boolean isBoundary) {
		List<BinaryTreeNode> result = new LinkedList<>();
		
		if(subtreeRoot != null) {
			System.out.println("subtreeRoot: "+subtreeRoot.data+" isBoundary: "+isBoundary+" isLeaf(subtreeRoot): "+isLeaf(subtreeRoot)+" result: "+result);
			
			if(isBoundary || isLeaf(subtreeRoot)) {
				result.add(subtreeRoot);
			}
			
			if(subtreeRoot.left != null && subtreeRoot.right != null)
				System.out.println("subtreeRoot.left: "+subtreeRoot.left.data+" subtreeRoot.right: "+subtreeRoot.right.data);
			else
				System.out.println("subtreeRoot.left: "+subtreeRoot.left+" subtreeRoot.right: "+subtreeRoot.right);
			
			result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
			result.addAll(leftBoundaryAndLeaves(subtreeRoot.right, isBoundary && subtreeRoot.left == null));
		}
		return result;
	}
	
	public static List<BinaryTreeNode> rightBoundaryAndLeaves(BinaryTreeNode subtreeRoot, boolean isBoundary) {
		List<BinaryTreeNode> result = new LinkedList<>();
		
		if(subtreeRoot != null) {
			System.out.println("subtreeRoot: "+subtreeRoot.data+" isBoundary: "+isBoundary+" isLeaf(subtreeRoot): "+isLeaf(subtreeRoot)+" result: "+result);
			
			if(subtreeRoot.left != null && subtreeRoot.right != null)
				System.out.println("subtreeRoot.left: "+subtreeRoot.left.data+" subtreeRoot.right: "+subtreeRoot.right.data);
			else
				System.out.println("subtreeRoot.left: "+subtreeRoot.left+" subtreeRoot.right: "+subtreeRoot.right);
			
			result.addAll(rightBoundaryAndLeaves(subtreeRoot.left, isBoundary && subtreeRoot.right == null));
			result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
			
			if(isBoundary || isLeaf(subtreeRoot)) {
				result.add(subtreeRoot);
			}
		}
		return result;
	}
	
	public static boolean isLeaf(BinaryTreeNode node) {
		return node.left == null && node.right == null;
	}
	
	public static void main(String[] args) {
		ComputeExteriorOfBinaryTree tree = new ComputeExteriorOfBinaryTree();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		List<BinaryTreeNode> result = exteriorBinaryTree(tree.root);
		
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i).data+" ");
		}
	}

}
