package io.waterdrop.datastructure.queue;

import java.util.Iterator;

/**
 * 
 */

import java.util.Stack;

public class QueueBaseTwoStacks<Element> {
	private Stack<Element> input = new Stack<>();
	private Stack<Element> output = new Stack<>();

	private void add(Element e) {
		input.push(e);
	}

	private Element delete() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				Element a = input.pop();
				//System.out.println(a);
				output.push(a);
			}
		}

		return output.pop();
	}

	private boolean isEmpty() {
		return (input.size() + output.size() <= 0);
	}

	public static void main(String[] args) {
		QueueBaseTwoStacks<Integer> queue = new QueueBaseTwoStacks<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		while (!queue.isEmpty()) {
			System.out.println(queue.delete());
		}

	}

}
