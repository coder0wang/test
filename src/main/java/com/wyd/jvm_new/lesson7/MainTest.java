package com.wyd.jvm_new.lesson7;


public class MainTest {

	Thread t1 = new Thread(new Runnable() {
		public void run() {
			try {
				Thread.sleep(1000);
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1");
		}
	});
	Thread t2 = new Thread(new Runnable() {
		public void run() {
			try {
				Thread.sleep(1000);
				t3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t2");
		}
	});
	Thread t3 = new Thread(new Runnable() {
		public void run() {
			try {
				Thread.sleep(1000);
				t4.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t3");
		}
	});
	Thread t4 = new Thread(new Runnable() {
		public void run() {
			try {
				Thread.sleep(1000);
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t3");
		}
	});
	public void test(){
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	public static void main(String[] args) {
		MainTest l = new MainTest();
		l.test();
	}
}
