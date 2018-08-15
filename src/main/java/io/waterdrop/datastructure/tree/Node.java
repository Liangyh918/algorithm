package io.waterdrop.datastructure.tree;

public class Node<T extends Comparable<T>> {
	T value;
	Node<T> left;
	Node<T> right;

	public Node(T item) {
		value = item;
		left = right = null;
	}

	public void insert(T t) {
		Node node = new Node(t);
		
	}
}
