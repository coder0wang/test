package com.wyd.thread.lesson2;
/**
 * 

* @Title: Lesson2Two.java 

* @Package com.wyd.thread.lesson2 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2015-9-21 上午12:46:35 

* @version V1.0
 */
public class Lesson2One {
	
	Thread t1 = new Thread(new Runnable() {
		public void run() {
			System.out.println("t1");
		}
	});
	Thread t2 = new Thread(new Runnable() {
		public void run() {
			try {
				//引用t1，等待t1完了执行
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t2");
		}
	});
	Thread t3 = new Thread(new Runnable() {
		public void run() {
			try {
				//引用t2，等待t2完了执行
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t3");
		}
	});
	public void test(){
		t3.start();
		t2.start();
		t1.start();
	}
	public static void main(String[] args) {
		Lesson2One l = new Lesson2One();
		l.test();
	}
}

