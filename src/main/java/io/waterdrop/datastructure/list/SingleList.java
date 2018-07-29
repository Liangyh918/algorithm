package io.waterdrop.datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * （头节点作为链表的第一个元素,而不仅仅作为一个指向链表的指针。链表插入分头插法和尾插法，该程序使用的是头插法）
 * （一般情况下head元素作为一个空节点而不存储任何数据比较好用，无论是迭代还是删除指定元素都更简单，该程序没有按照这种方法）
 * 
 * 1.定义节点
 * 
 * 2.定义链表成员变量
 * 
 * 3.向链表头插入元素，从链表头删除元素
 * 
 * 4.向链表指定位置插入元素，删除指定位置的元素
 * 
 * 5.迭代器
 * 
 * 6.逆转链表（递归和非递归）
 * 
 * 
 * @author liangyh
 *
 * @param <Element>
 */

public class SingleList<Element> implements Iterable<Element> {
	private Node<Element> head;
	private int size;

	public SingleList() {
		head = null; // error point : 之前的写法是 head = new
						// Node(null),导致链表迭代器多迭代了一个空元素，这种写法可以用在
		// head节点不属于链表节点时，但是如果head也作为一个存储内容的节点时此处就不能实例化;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size<=0;
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public boolean insertHead(Element e) {
		Node<Element> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		return true;
	}

	public boolean insertNthNode(Element e, int pos) {
		Node currentNode = head;
		Node newNode = new Node(e);
		while (pos > 0) {
			currentNode = currentNode.next;
			pos--;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		size++;
		return true;

	}

	public Element deleteHead() {
		Element element = head.content;
		head = head.next;
		size--;
		return element;
	}

	public boolean deleteElements(Element e) {
		Node<Element> testNode = head;
		Node<Element> connectionNode = new Node(null);
		connectionNode.next = head;
		// 该循环可保证每轮循环结束时connectionNode.next == testNode成立;
		while (testNode != null) {
			if (testNode.content == e || testNode.content.equals(e)) {
				if (testNode == head) {
					head = testNode.next;
					// connectionNode.next = head;
				}
				connectionNode.next = testNode.next;// 链接作用
				// connectionNode = connectionNode.next;//
				// 如果删除元素，connectionNode不用移动
				size--;
			} else {
				connectionNode = connectionNode.next;// 只有当被检查节点不需要删除时，链接节点才需要后移一位
			}
			testNode = testNode.next;// 无论被检查的节点是否需要删除，testNode都要后移
		}
		return true;
	}

	private class Node<Element> {
		Element content;
		Node<Element> next;

		public Node(Element element) {
			content = element;
			next = null;
		}
	}

	private class ListIterator<Element> implements Iterator<Element> {
		private Node<Element> currentNode  =new Node<Element>(null);
		//error point:原写法private Node<Element> currentNode =new Node<Element>(null),导致错误，
		//当使用迭代器删除元素时，

		@SuppressWarnings("unused")
		public ListIterator(Node<Element> head) {
			currentNode.next = head;// error point：之前的写法是currentNode =
									// head，导致漏掉头节点;
		}

		@Override
		public boolean hasNext() {
			return currentNode.next != null;
		}

		@Override
		public Element next() {
			if (!hasNext()) {
				throw new NoSuchElementException();

			}
			currentNode = currentNode.next;
			return currentNode.content;
		}

	}

	@Override
	public Iterator<Element> iterator() {
		return new ListIterator<Element>(head);
	}

	public static void main(String[] args) {
		SingleList<String> list = new SingleList<String>();

		list.insertHead("1");
		list.insertHead("2");
		list.insertHead("3");
		list.insertHead("3");
		list.insertHead("4");
		list.insertHead("5");
		System.out.println(list.size);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("---------------------------------------------------------------------------");
		list.deleteElements("3");
		for (String string : list) {
			System.out.println(string);
		}
		String string = list.deleteHead();
		System.out.println(string);
	}
}
