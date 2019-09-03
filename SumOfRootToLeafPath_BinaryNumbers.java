package BinaryTrees;

/**
 * Page 132
 * 9.5 Design an algorithm to compute the sum of the binary numbers represented by the root-to-leaf paths.
 * @author NisuBhakti
 * Time Complexity: O(n), Space Complexity: O(h)
 */

public class SumOfRootToLeafPath_BinaryNumbers {

	public static int sumRootToLeaf(BinaryTreeNode root) {
		return sumRootToLeafHelper(root, 0);
	}
	
	public static int sumRootToLeafHelper(BinaryTreeNode root, int partialPathSum) {
		if(root == null)
			return 0;
		
		partialPathSum = partialPathSum * 2 + root.data;
		
		if(root.left == null && root.right == null) {					//Leaf
			return partialPathSum;
		}
		
		return sumRootToLeafHelper(root.left, partialPathSum) + sumRootToLeafHelper(root.right, partialPathSum);		//Non-leaf
	}
	
	public static void main(String[] args) {

	}

}
