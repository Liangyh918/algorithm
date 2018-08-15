package io.waterdrop.datastructure.list;

import java.util.Iterator;

public class DoubledLinkedList<E extends Comparable<T>, T> implements Iterable<T> {
	private Link<E> head;
	private Link<E> tail;
	int size;

	public DoubledLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	private void insertHead(E e) {

	}

	private void insertTail(E e) {

	}

	public void insertOrdered(E e) {

	}

	public void deleteHead() {

	}

	public void deleteTail() {

	}

	public void delete(E e) {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size > 0;
	}

	class Link<E extends Comparable<T>> {
		public E value;
		public Link next;
		public Link previous;

		public Link(E value) {
			this.value = value;
		}
	}

	class DoubleLinkedListIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
