package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class StateAllRootToLeafPathWithSpecifiedSum {

	BinaryTreeNode root;
	
	public static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentResult = new LinkedList<>();
		pathSum(root, sum, currentResult, result);
		return result;
	}
	
	public static void pathSum(BinaryTreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
		if(root == null)
			return;
		
		currentResult.add(new Integer(root.data));
		
		if(root.left == null && root.right == null && root.data == sum) {
			result.add(new LinkedList<Integer>(currentResult));
			currentResult.remove(currentResult.size()-1);
			return;
		}
		else {
			pathSum(root.left, sum - root.data, currentResult, result);
			pathSum(root.right, sum - root.data, currentResult, result);
		}
		currentResult.remove(currentResult.size()-1);
	}
	
	public static void main(String[] args) {
		StateAllRootToLeafPathWithSpecifiedSum tree = new StateAllRootToLeafPathWithSpecifiedSum();
		
		tree.root = new BinaryTreeNode(5);
		tree.root.left = new BinaryTreeNode(4);
		tree.root.left.left = new BinaryTreeNode(11);
		tree.root.left.left.left = new BinaryTreeNode(7);
		tree.root.left.left.right = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(8);
		tree.root.right.left = new BinaryTreeNode(13);
		tree.root.right.right = new BinaryTreeNode(4);
		tree.root.right.right.left = new BinaryTreeNode(5);
		tree.root.right.right.right = new BinaryTreeNode(1);
		
		System.out.println(pathSum(tree.root, 22));
	}

}
