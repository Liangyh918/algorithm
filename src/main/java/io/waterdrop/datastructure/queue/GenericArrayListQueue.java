package io.waterdrop.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayListQueue<T> {
	private List<T> queue = new ArrayList();

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean hasNext() {
		return size() > 0;
	}

	public T peek() {
		if (hasNext()) {
			return queue.get(0);
		}
		return null;
	}

	public T poll() {
		if (hasNext()) {
			return queue.remove(0);
		}
		return null;
	}

	private void add(T e) {
		queue.add(e);
	}
}
