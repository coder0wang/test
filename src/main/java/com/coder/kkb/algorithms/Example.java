package com.coder.kkb.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 此类描述的是：  
 * 数据结构算法重要性实例
 * @author: Coder_Wang 
 * @version: 2019年1月28日 下午5:03:44
 */
public class Example {

	public static List<Integer> listNoLength = new ArrayList<>();
	
	public static List<Integer> listLength = new ArrayList<>(1024);
	
	
	public static void start(int sign){
		CountDownLatch latch=new CountDownLatch(10);
		ExecutorService service = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					try {
						latch.await();
						addList(sign);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
		
		latch.countDown();
		
	}
	
	public static void addList(int sign){
		for (int i = 0; i < 1024; i++) {
			if(sign==0){
				listNoLength.add(123);
			}
		}
	}
	
	
}
