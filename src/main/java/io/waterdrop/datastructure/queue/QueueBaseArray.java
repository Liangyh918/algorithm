package io.waterdrop.datastructure.queue;
/**
 * 使用数组实现队列
 * 
 * @author liangyh
 *
 * @param <T>
 */
public class QueueBaseArray<T> {
	private int maxSize;// 队列最大长度
	private Object[] queue;
	private int size;
	private int front;
	private int rear;

	public QueueBaseArray(int maxSize) {
		this.maxSize = maxSize;
		queue = new Object[maxSize];
		front = -1;
		rear = -1;
		size = 0;
	}

	public boolean isEmpty() {
		return !(size > 0);
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public boolean add(T t) {
		if (isFull()) {
			throw new IllegalStateException();
			// 或者考虑增大队列容量
		}
		if (rear == maxSize - 1) {
			rear = -1;
		}
		rear++;
		queue[rear] = t;
		size++;

		return true;
	}

	public T remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		T t = (T) queue[front];
		if (front == maxSize - 1) {
			front = -1;
		}
		front++;
		size--;
		return t;
	}

}
