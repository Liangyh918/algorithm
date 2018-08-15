package io.waterdrop.datastructure.queue;

/**
 * 优先队列的含义是插入元素时，按照元素的优先级别插入到对应位置
 * 
 * 可以有链表实现和数组实现
 * 
 * @author liangyh
 *
 */
public class PriorityQueue<Element extends Comparable<Element>> {
	private Element[] table;
	private int rear;
	private int size;
	private int maxSize;

	public PriorityQueue(int maxSize) {
		table = (Element[]) new Object[maxSize];
		this.maxSize = maxSize;
		rear = 0;
		size = 0;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	private void insertElement(Element e) {
		if (isFull()) {
			throw new IllegalStateException();
		}

		for (int i = size - 1;; i--) {
			if (e.compareTo(table[i]) > 0) {
				table[i + 1] = table[i];
			} else {
				table[i + 1] = e;
				size++;
			}
		}
	}

	private void deleteElement() {
		for (int i = 0; i < size - 1; i++) {
			table[i] = table[i + 1];
		}
	}

}
