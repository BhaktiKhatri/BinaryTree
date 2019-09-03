package BinaryTrees;

/**
 * 9.17 Implement locking in a binary tree
 * Page 146
 * @author NisuBhakti
 * Time complexity for locking and unlocking is bounded by the depth of the node, which, in the worst case is the tree height i.e. O(h)
 * Additional space complexity is O(1) for each node i.e. O(n) for the entire tree
 * Time complexity for checking whether a node is already locked remains O(1)
 */

public class LockingInBinaryTree {

	public LockingInBinaryTree left, right, parent;
	public boolean locked = false;
	public int numLockedDescendants = 0;
	
	public boolean isLocked() {
		return locked;
	}
	
	public boolean lock() {
		//We cannot lock if any of this node's descendants are locked
		if(numLockedDescendants > 0 || locked) {
			return false;
		}
		
		//We cannot lock if any of this node's ancestors are locked
		for(LockingInBinaryTree curr = parent; curr != null; curr = curr.parent) {
			if(curr.locked) {
				return false;
			}
		}
		
		//Lock this node and increments all its ancestors' descendant lock counts
		locked = true;
		for(LockingInBinaryTree curr = parent; curr != null; curr = curr.parent) {
			++curr.numLockedDescendants;
		}
		
		return true;
	}
	
	public void unlock() {
		if(locked) {
			//Unlocks itself and decrements its ancestors' descendants lock counts
			locked = false;
			for(LockingInBinaryTree curr = parent; curr != null; curr = curr.parent) {
				--curr.numLockedDescendants;
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
