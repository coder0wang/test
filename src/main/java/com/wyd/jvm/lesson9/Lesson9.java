package com.wyd.jvm.lesson9;

import java.util.List;
import java.util.Vector;
/**
 * 

* @Title: Lesson9.java 

* @Package com.wyd.jvm.lesson9 

* @Description: 高并发第九课作业

* @author Coder 

* @date 2015-11-15 下午11:33:37 

* @version V1.0
 */
public class Lesson9 {
	public static List<Integer> numberList = new Vector<Integer>();
	public static void main(String[] args) throws InterruptedException {
		long begin = System.currentTimeMillis();
		int count = 0;
		int startnum = 0;
		while (count < 10000000) {
			numberList.add(startnum);
			startnum += 2;
			count++;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		//-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
		//6693 6895 6773 6801 6783
		
		//-XX:-UseBiasedLocking
		//7002 6900 6988 6878 6993
	}
}
