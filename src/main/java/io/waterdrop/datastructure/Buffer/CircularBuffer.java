package io.waterdrop.datastructure.Buffer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 1.首先确定循环缓存的数据结构
 * 
 * 2.需要读取和写入功能，为支持这两种功能需要设置读取指针和写入指针
 * 
 * 3.循环缓存的长度为什么需要是2的指数，
 * 
 * 4.判空，判满，
 * 
 * 5.对多线程的支持
 * 
 * @author liangyh
 *
 */
public class CircularBuffer {
	private char[] buffer;
	public int maxBufferSize;
	private int writeIndex = 0;
	private int readIndex = 0;
	private AtomicInteger readableData = new AtomicInteger(0);

	public boolean isPowerOfTwo(int i) {
		return (i & (i - 1)) == 0;
	}

	public int getTrueIndex(int i) {
		return i % maxBufferSize;
	}

	public CircularBuffer(int bufferSize) {
		if (!isPowerOfTwo(bufferSize)) {
			throw new IllegalArgumentException();
		}
		buffer = new char[bufferSize];
		maxBufferSize = bufferSize;
		writeIndex = 0;
		readIndex = 0;
	}

	public Character readChar() {
		Character result = null;
		if (readableData.get() > 0) {
			result = buffer[getTrueIndex(readIndex)];
			readableData.decrementAndGet();
			readIndex++;
		}
		return result;
	}

	public boolean writeToBuffer(char c) {
		boolean result = false;
		if (readableData.get() < maxBufferSize) {
			buffer[getTrueIndex(writeIndex)] = c;
			writeIndex++;
			readableData.incrementAndGet();
			result = true;
		}
		return result;
	}

	private static class TestWriteWorker implements Runnable {
		String _alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random _random = new Random();
		CircularBuffer _buffer;

		public TestWriteWorker(CircularBuffer cb) {
			this._buffer = cb;
		}

		private char getRandomChar() {
			return _alphabet.charAt(_random.nextInt(_alphabet.length()));
		}

		public void run() {
			while (!Thread.interrupted()) {
				if (!_buffer.writeToBuffer(getRandomChar())) {
					Thread.yield();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						return;
					}
				}
			}
		}
	}

	private static class TestReadWorker implements Runnable {
		CircularBuffer _buffer;

		public TestReadWorker(CircularBuffer cb) {
			this._buffer = cb;
		}

		public void run() {
			System.out.println("Printing Buffer:");
			while (!Thread.interrupted()) {
				Character c = _buffer.readChar();
				if (c != null) {
					System.out.print(c.charValue());
				} else {
					Thread.yield();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						System.out.println();
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int buffer_size = 1024;
		// create circular buffer
		CircularBuffer cb = new CircularBuffer(buffer_size);

		// create threads that read and write the buffer.
		Thread write_thread = new Thread(new TestWriteWorker(cb));
		Thread read_thread = new Thread(new TestReadWorker(cb));
		read_thread.start();
		write_thread.start();

		// wait some amount of time
		Thread.sleep(10000);

		// interrupt threads and exit
		write_thread.interrupt();
		read_thread.interrupt();
	}

}
