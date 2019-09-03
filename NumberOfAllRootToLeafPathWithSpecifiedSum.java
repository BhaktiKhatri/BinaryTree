package BinaryTrees;

import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value. Find the number of paths that sum to a given value.
 * Explanation and Code from: https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
 * @author NisuBhakti
 * 
 */

public class NumberOfAllRootToLeafPathWithSpecifiedSum {

	BinaryTreeNode root;
	
	public static int pathSum(BinaryTreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public static int helper(BinaryTreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        System.out.println("root: "+root.data+" currSum: "+currSum+" target: "+target+" preSum: "+preSum);
        currSum = currSum + root.data;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res = res + helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
	
	public static void main(String[] args) {
		NumberOfAllRootToLeafPathWithSpecifiedSum tree = new NumberOfAllRootToLeafPathWithSpecifiedSum();
		
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
