package com.wyd.jvm_new.lesson9;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
* @Title: Lesson9.java 

* @Package com.wyd.jvm_new.lesson9 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-11-13 下午11:42:38 

* @version V1.0
 */
public class Lesson9 {

	
	public static synchronized Integer syncPlus(int i){
		return i++;
	}
	public static Integer plus(int i){
		return i++;
	}
	
	public static void doPlus(int n ) throws InterruptedException{
		if (sign ==0) {
			System.out.println("同步 有锁");
			}else {
				System.out.println("非同步 无锁");
			}
		List<Thread> list = Collections.synchronizedList(new LinkedList());
		for (int i = 0; i < n; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					while (num<max) {
						if (sign ==0) {
							num = syncPlus(num);
						}else {
							num = plus(num);
						}
						num ++;
						if (num ==max ) {
							long time = System.currentTimeMillis();
							System.out.println("结束时间为  : "+time);
							System.out.println(" 时间差为 : " + (time-syncBeforeTime));
						}
					}
					
				}
			});
			list.add(thread);
		}
		///懒了一把没有用线程池 ,望老师见谅 用CountDownLatch 会好点
		for (int i = 0; i < list.size(); i++) {
			Thread temp = list.get(i);
			temp.run();
		}
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	static int num = 0;
	static int max = 1000000;
	static long syncBeforeTime = System.currentTimeMillis();
	//0有锁 1 无锁
	static int sign = 1;
	public static void main(String[] args) throws InterruptedException {
		
		int time = 1000;
		System.out.println("线程数为  " + time);
		System.out.println("开始时间 : " +syncBeforeTime);
		doPlus(time);
//		long syncAfterTime = System.currentTimeMillis();
//		System.out.println(syncAfterTime-syncBeforeTime); 
	}

}
