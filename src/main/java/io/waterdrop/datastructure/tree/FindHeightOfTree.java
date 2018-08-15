package io.waterdrop.datastructure.tree;

public class FindHeightOfTree {
	public static int findHtightOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(findHtightOfTree(root.left), findHtightOfTree(root.right));
	}

	public static void main(String args[]) {

		Node root = new Node(8);
		root.left = new Node(10);
		root.right = new Node(5);
		root.left.left = new Node(11);
		root.left.right = new Node(3);

		System.out.println(findHtightOfTree(root.left));

	}

}
