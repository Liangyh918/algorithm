package io.waterdrop.datastructure.tree;

public class BSTOrNot {
	Node root;

	/**
	 * better one
	 * @param root
	 * @return
	 */
	public static  boolean isBstBetter(Node root) {
		
		/**
		 * 1.处理边界情况，返回ture
		 */
		if(root==null|| (root.left == null && root.right == null)){
			return true;
		}
		/**
		 * 2.处理不满足bst条件的情况
		 */
		if(root.left!=null && root.left.value.compareTo(root.value)>0){
			return false;
		}
		if(root.right!=null && root.right.value.compareTo(root.value)<0){
			return false;
		}
		/**
		 * 3.递归
		 */
		return isBstBetter(root.left)&&isBstBetter(root.right);
		
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBst(Node root) {

		/**
		 * 1.处理边界情况
		 */
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		/**
		 * 2.针对节点root存在子节点且root和其子节点关系为搜索树要求的关系时的情况做递归处理
		 */
		if (root.left != null && root.right != null) {
			if ((root.left.value.compareTo(root.value) <= 0) && (root.right.value.compareTo(root.value) >= 0)) {
				return isBst(root.left) && isBst(root.right);
			}
		}
		if (root.left != null && root.right == null && root.left.value.compareTo(root.value) <= 0) {
			return isBst(root.left);
		}
		if (root.left == null && root.right != null && root.right.value.compareTo(root.value) >= 0) {
			return isBst(root.right);
		}
		/**
		 * 3. root和其子节点关系不满足搜索树要求的关系时
		 */
		return false;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		Node root = new Node(8);
		root.left = new Node(10);
		// root.right = new Node(5);
		root.left.left = new Node(11);
		// root.left.right = new Node(3);

		if (isBstBetter(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
