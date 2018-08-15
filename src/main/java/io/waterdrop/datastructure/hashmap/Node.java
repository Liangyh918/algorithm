package io.waterdrop.datastructure.hashmap;

import java.util.Map;
import java.util.Objects;

class Node<K, V> implements Map.Entry<K, V> {

	int hash;
	K key;
	V value;
	Node<K, V> next;

	Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public final int hashCode(K key, V value) {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
		// error-point:原写法key.hashCode()^value.hashCode()，这种情况可能会NullPointerException
	}

	public final boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o instanceof Map.Entry) {
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V newValue) {
		V oldValue = value;
		value = newValue;
		return oldValue;
	}
}
