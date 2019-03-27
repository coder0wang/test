package com.wyd.thread.lesson4;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 
 * @Title: RingBuffer.java
 * 
 * @Package com.wyd.thread.lesson4
 * 
 * @Description: TODO(用一句话描述该文件做什么)
 * 
 * @author Coder
 * 
 * @date 2015-10-11 下午11:46:30
 * 
 * @version V1.0
 */
public class RingBuffer<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6976960108708949038L;

	private volatile AtomicInteger head;

	private volatile AtomicInteger tail;

	private int length;

	final T EMPTY = null;

	private volatile T[] queue;

	public RingBuffer(Class<T> type, int length) {
		this.head = new AtomicInteger(0);
		this.tail = new AtomicInteger(0);
		this.length = length == 0 ? 2 << 16 : length; // 默认2^16
		this.queue = (T[]) Array.newInstance(type, this.length);
	}

	public void enQueue(T t) {
		if (t == null)
			t = (T) new Object();
		// 阻塞 -- 避免多生成者循环生产同一个节点
		while (this.getTail() - this.getHead() >= this.length)
			;
		int ctail = this.tail.getAndIncrement();
		while (this.queue[this.getTail(ctail)] != EMPTY)
			; // 自旋
		this.queue[this.getTail(ctail)] = t;
	}

	public T deQueue() {
		T t = null;
		// 阻塞 -- 避免多消费者循环消费同一个节点
		while (this.head.get() >= this.tail.get())
			;
		int chead = this.head.getAndIncrement();
		while (this.queue[this.getHead(chead)] == EMPTY)
			; // 自旋
		t = this.queue[this.getHead(chead)];
		this.queue[this.getHead(chead)] = EMPTY;
		return t;
	}

	public int getHead(int index) {
		return index & (this.length - 1);
	}

	public int getTail(int index) {
		return index & (this.length - 1);
	}

	public int getHead() {
		return head.get() & (this.length - 1);
	}

	public int getTail() {
		return tail.get() & (this.length - 1);
	}

	public T[] getQueue() {
		return queue;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public static AtomicInteger index = new AtomicInteger(0);
	public static void main(String[] args) {

		int tCount = 10; // thread count
		int length = 0; // buffer length -> 2^16

		final RingBuffer<Integer> buffer = new RingBuffer<Integer>(
				Integer.class, length);
		// provider
		Runnable pr = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int tindex = index.getAndIncrement();
					buffer.enQueue(tindex);
					System.out.println("buffer enQueue: " + tindex);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// consumer
		Runnable cr = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Integer cindex = buffer.deQueue();
					System.out.println("buffer deQueue: " + cindex);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		for (int i = 0; i < tCount; i++) {
			new Thread(cr).start();
		}

		for (int i = 0; i < tCount; i++) {
			new Thread(pr).start();
		}
	}
}
