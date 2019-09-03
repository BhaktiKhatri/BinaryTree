package BinaryTrees;

public class LowestCommonAncestorWithParentPointer {

	public static BinaryTreeNode LCA(BinaryTreeNode node1, BinaryTreeNode node2) {
		int depth1 = getDepth(node1);
		int depth2 = getDepth(node2);
		
		if(depth2 > depth1) {					//Make node1 as the deeper node in order to simplify the code
			BinaryTreeNode temp = node1;
			node1 = node2;
			node2 = temp;
		}
		
		//Ascends from the deeper node
		int depthDiff = Math.abs(depth1 - depth2);
		while(depthDiff-- > 0) {
			node1 = node1.parent;
		}
		
		//Now ascends both nodes until we reach the LCA
		while(node1 != node2) {
			node1 = node1.parent;
			node2 = node2.parent;
		}
		
		return node1;
	}
	
	public static int getDepth(BinaryTreeNode node) {
		int depth = 0;
		while(node.parent != null) {
			++depth;
			node = node.parent;
		}
		return depth;
	}
	
	public static void main(String[] args) {
		
	}

}
