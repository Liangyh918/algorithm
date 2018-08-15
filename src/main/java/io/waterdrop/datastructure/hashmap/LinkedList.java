package io.waterdrop.datastructure.hashmap;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 采用尾插法构造链表，需要3个指针，head,tail,searcher;
 * 
 * 
 * @author liangyh
 *
 */
public class LinkedList<K, V> {
	private Node<K, V> head;
	private Node<K, V> tail;
	private Node<K, V> currentNode;
	int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public boolean insert(K key, V value) {
		Node<K, V> node = new Node<>(key, value);
		if (head == null) {
			head.next = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		return true;
	}

	public boolean delete(K key) {
		currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.next.getKey() == key) {
				currentNode.next = currentNode.next.next;
			}
		}
		return true;
	}

	public boolean containsKey() {
		return false;

	}

	private class LinkedListKeyIterator implements Iterator<K> {
		Node currentNode = head;

		@Override
		public boolean hasNext() {
			while (currentNode.next != null) {
				return true;
			}
			return false;
		}

		@Override
		public K next() {
			if (!hasNext())
				throw new NoSuchElementException();
			K key = (K) currentNode.next.getKey();
			currentNode = currentNode.next;
			return key;
		}

	}
}
