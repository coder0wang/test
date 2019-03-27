package com.wyd.jvm.lesson4;

import java.util.ArrayList;
import java.util.List;


public class MyThread extends Thread{
	List<byte[]> list = new ArrayList<byte[]>();
	@Override
	public  void run(){
		try{
			while(true){
				if(list.size()*512/1024/1024>=450){
					System.out.println("=====准备清理=====:"+list.size());
					list.clear();
				}
				
				for(int i=0;i<1024;i++){
					list.add( new byte[1024]);
				}
				Thread.sleep(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		System.out.println("123");
		PrintThread printThread = new PrintThread();
		printThread.start();
	}
}
