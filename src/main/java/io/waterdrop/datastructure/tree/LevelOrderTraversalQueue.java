package io.waterdrop.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalQueue<T extends Comparable<T>> {
	static List<Node>  queue = new ArrayList<Node>();

	public static void levelOrderTraversalQueue(Node root) {
		// TODO Auto-generated method stub
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp =  queue.get(0);
			queue.remove(0);
			visit(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

	}

	private static void visit(Node node) {
		System.out.print(node.value+" ");
	}
	
	
	 public static void main(String args[]) 
	    {
	        /* creating a binary tree and entering 
	         the nodes */
	        Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	 
	        System.out.println("Level order traversal of binary tree is - ");
	        levelOrderTraversalQueue(root);
	    }
}
