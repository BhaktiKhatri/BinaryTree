package BinaryTrees;

/**
 * Page 133
 * 9.6 Find a root to leaf path with specified sum
 * @author NisuBhakti
 * Time Complexity: O(n); Space Complexity: O(h)
 */

public class RootToLeafPathWithSpecifiedSum {

	BinaryTreeNode root;
	
	public static boolean hasPathSum(BinaryTreeNode root, int remainingWeight) {
		if(root != null)
			System.out.println("root: "+root.data+" remainingWeight: "+remainingWeight);
		
		if(root == null) {
			return false;
		}
		else if(root.left == null && root.right == null) {		//Leaf
			return remainingWeight == root.data;
		}
		return hasPathSum(root.left, remainingWeight - root.data) || hasPathSum(root.right, remainingWeight - root.data);	//Non-leaf
	}
	
	public static void main(String[] args) {
		RootToLeafPathWithSpecifiedSum tree = new RootToLeafPathWithSpecifiedSum();
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		System.out.println(hasPathSum(tree.root, 30));
	}

}
