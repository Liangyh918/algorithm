package io.waterdrop.datastructure.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 需要的功能： 1.定义bag的元素
 * 
 * 2.添加元素
 * 
 * 3.判空
 * 
 * 4.获取大小
 * 
 * 5.迭代器(迭代器的定义如何实现)
 * 
 * 6.判断给定元素是否存在
 * 
 * 7.获取某元素
 * 
 * error:迭代器的编写
 * 
 * @author liangyh
 *
 */
public class Bag<Element> implements Iterable<Element> {
	private int size = 0;
	private Node<Element> firstElement = new Node<Element>();

	private static class Node<Element> {
		Element content;
		Node<Element> next;

	}

	public Bag() {

	}

	/*
	 * 插入元素是否需要返回值，返回值设置为什么类型比较好呢
	 */
	public boolean add(Element element) {
		Node node = new Node<Element>();
		node.content = element;
		if (firstElement.next == null) {
			firstElement.next = node;
		} else {
			node.next = firstElement.next;
			firstElement.next = node;//error point，原来的写法 firstElement.next = node
		}
		size++;
		return true;
	}

	/*
	 * 判空
	 */
	public boolean isEmpty() {
		return size > 0;
	}

	/**
	 * 获取大小
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断是否有某元素
	 */
	public boolean contains(Element element) {
		BagIterator<Element> bagIterator = new BagIterator<Element>(firstElement);
		while (bagIterator.hasNext()) {
			if (bagIterator.next().equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 迭代器
	 */
	@SuppressWarnings("hiding")
	private class BagIterator<Element> implements Iterator<Element> {
		private Node<Element> currentElement;

		public BagIterator(Node<Element> firstElement) {
			currentElement = firstElement;
		}

		@Override
		public boolean hasNext() {
			return currentElement.next != null;
		}

		@Override
		public Element next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentElement = currentElement.next;
			return currentElement.content;
		}

	}

	public static void main(String[] args) {
		Bag<String> bag = new Bag<>();

		bag.add("w");
		bag.add("1");
		bag.add("2");
		bag.add("7");
		bag.add("null");
		System.out.println("size of bag = " + bag.size());
		for (String s : bag) {
			System.out.println(s);
		}

		//System.out.println(bag.contains(null));
		System.out.println(bag.contains("1"));
		System.out.println(bag.contains("3"));
		System.out.println(bag.contains("null"));
	}

	@Override
	public Iterator<Element> iterator() {
		return new BagIterator<>(firstElement);
	}
}
