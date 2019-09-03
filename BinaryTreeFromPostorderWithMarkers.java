package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromPostorderWithMarkers {

	public static Integer subtreeIdx;
	
	public static BinaryTreeNode reconstructPostorder(List<Integer> postorder) {
		subtreeIdx = postorder.size()-1;
		System.out.println("postorder: "+postorder);
		return reconstructPostorderSubtree(postorder);
	}
	
	public static BinaryTreeNode reconstructPostorderSubtree(List<Integer> postorder) {
		Integer subtreeKey = postorder.get(subtreeIdx);
		System.out.println("subtreeKey: "+subtreeKey+" subtreeIdx: "+subtreeIdx);
		
		--subtreeIdx;
		System.out.println("subtreeIdx: "+subtreeIdx);
		
		if(subtreeKey == null)
			return null;
		
		BinaryTreeNode root = new BinaryTreeNode(subtreeKey);
		System.out.println("root: "+root.data);
		
		BinaryTreeNode rightSubtree = reconstructPostorderSubtree(postorder);
		BinaryTreeNode leftSubtree = reconstructPostorderSubtree(postorder);
		
		if(leftSubtree != null && rightSubtree != null)
			System.out.println("leftSubtree: "+leftSubtree.data+" rightSubtree: "+rightSubtree.data);
		else
			System.out.println("leftSubtree: "+leftSubtree+" rightSubtree: "+rightSubtree);
		
		root.left = leftSubtree;
		root.right = rightSubtree;
		
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> postorder = new ArrayList<>();
		postorder.add(null);
		postorder.add(null);
		postorder.add(9);
		postorder.add(null);
		postorder.add(null);
		postorder.add(15);
		postorder.add(null);
		postorder.add(null);
		postorder.add(7);
		postorder.add(20);
		postorder.add(3);
		
		BinaryTreeNode root = reconstructPostorder(postorder);
		
		System.out.println("      "+root.data);
		System.out.println("     /"+" \\");
		System.out.println("    "+root.left.data+"  "+root.right.data);
		System.out.println("       /"+" \\");
		System.out.println("      "+root.right.left.data+"  "+root.right.right.data);

	}

}
