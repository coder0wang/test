package com.coder.kkb.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类描述的是：  
 * 数据结构算法重要性实例
 * @author: Coder_Wang 
 * @version: 2019年1月28日 下午5:03:44
 */
public class ExampleList {
	static int length = 320;
	public static List<String> listNoLength = new ArrayList<>();
	public static List<String> listLength = new ArrayList<>(length);
	public static void addList(int sign){
		long start = System.nanoTime();
		for (int i = 0; i <length; i++) {
			if(sign==0){
				listNoLength.add("asdf");
			}else{
				listLength.add("asdf");
			}
		}
		long end =  System.nanoTime();
		System.out.println("Test: "+ sign+"   "+(end - start));
	}
	public static void main(String[] args) {
		addList(0);
		addList(1);
	}
}
