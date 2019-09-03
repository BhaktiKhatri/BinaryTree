package BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Practice {

	public static Integer subtreeIdx;
	
	public static void constructRightSibling(BinaryTreeNode root) {
		BinaryTreeNode leftStart = root;
		
		while(leftStart != null && leftStart.left != null) {
			populateLowerLevelNextField(leftStart);
			leftStart = leftStart.left;
		}
	}
	
	public static void populateLowerLevelNextField(BinaryTreeNode startNode) {
		BinaryTreeNode curr = startNode;
		
		while(curr != null) {
			curr.left.next = curr.right;
			
			if(curr.next != null) {
				curr.right.next = curr.next.left;
			}
			
			curr = curr.next;
		}
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
		
		BinaryTreeNode root = null;// = createListOfLeaves(postorder);
		
		//BinaryTreeNode root = reconstructPostorder(preorder);
		
		System.out.println("      "+root.data);
		System.out.println("     /"+" \\");
		System.out.println("    "+root.left.data+"  "+root.right.data);
		System.out.println("       /"+" \\");
		System.out.println("      "+root.right.left.data+"  "+root.right.right.data);

	}

}
