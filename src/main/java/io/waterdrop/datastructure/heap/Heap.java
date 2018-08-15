package io.waterdrop.datastructure.heap;

public interface Heap<T> {
	T getElement() throws EmptyHeapException;

	void insertElement(T t);

	void deleteElement(T t);
}
