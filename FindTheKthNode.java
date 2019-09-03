package BinaryTrees;

public class FindTheKthNode {
	
	BinaryTreeNode root;
	
	/*
			   1
			  / \
			 2   3
			/   / \
		   4    5  6
		       /
		      7
	 */

	public static BinaryTreeNode findKthNodeBinaryTree(BinaryTreeNode root, int k) {
		BinaryTreeNode curr = root;
		
		System.out.println("curr: "+curr.data);
		
		while(curr != null) {
			int leftSize = curr.left != null ? curr.left.size : 0;
			
			System.out.println("leftsie: "+leftSize+" k: "+k+" curr: "+curr.data);
			
			if(leftSize + 1 < k) {			//k-th node must be in the right subtree of curr
				k = k - (leftSize + 1);
				curr = curr.right;
			}
			else if(leftSize + 1 == k ) {	//k-th node is curr itself
				return curr;
			}
			else {							//k-th node must be in the left subtree
				curr = curr.left;
			}
		}
		
		return null;						//if k is between 1 and tree size, this line is unreachable
	}
	
	public static void main(String[] args) {
		FindTheKthNode tree = new FindTheKthNode();
		
		/*
		 					   1
		 					  / \
		 					 2   3
		 					/   / \
		 				   4    5  6
		 				       /
		 				       7
		 */
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.right.left = new BinaryTreeNode(5);
		tree.root.right.left.left = new BinaryTreeNode(7);
		tree.root.right.right = new BinaryTreeNode(6);
		
		System.out.println(findKthNodeBinaryTree(tree.root, 3).data);
	}

}
