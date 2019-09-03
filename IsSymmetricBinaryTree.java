package BinaryTrees;

/**
 * Page: 128
 * WAP that checks whether a binary tree is symmetric
 * @author NisuBhakti
 * Time Complexity: O(n), where n is the number of nodes in the tree; Space Complexity: O(h), where h is the height of the tree 
 */

public class IsSymmetricBinaryTree {
	
	BinaryTreeNode root;

	public static boolean isSymmetric(BinaryTreeNode root) {
		if(root == null)
			return true;
		
		return checkSymmetric(root.left, root.right);
	}
	
	public static boolean checkSymmetric(BinaryTreeNode subtreeL, BinaryTreeNode subtreeR) {
		if(subtreeL == null && subtreeR == null) {
			return true;
		}
		else if(subtreeL != null && subtreeR != null) {
			return subtreeL.data == subtreeR.data && checkSymmetric(subtreeL.left, subtreeR.right) && checkSymmetric(subtreeL.right, subtreeR.left);
		}
		
		return false; 	//one subtree is null and the other is not
	}
	
	public static void main(String[] args) {
		IsSymmetricBinaryTree tree = new IsSymmetricBinaryTree();
		
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(3);
        tree.root.left.right = new BinaryTreeNode(4);
        tree.root.right.left = new BinaryTreeNode(4);
        tree.root.right.right = new BinaryTreeNode(3);
        
        boolean output = isSymmetric(tree.root);
        
        if (output == true)
            System.out.println("Binary tree is symmetric");
        else
            System.out.println("Binary tree is not symmetric");
	}

}
