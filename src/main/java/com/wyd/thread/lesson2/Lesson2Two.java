package com.wyd.thread.lesson2;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 

* @Title: Lesson2Two.java 

* @Package com.wyd.thread.lesson2 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2015-9-21 上午12:46:35 

* @version V1.0
 */
public class Lesson2Two {
	
    private Queue<Integer> queue = new ArrayBlockingQueue<Integer>(20);
    
    public synchronized void add(int num){
        while(queue.size() == 20){
        	System.out.println("full,wait!");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        queue.add(num);
    }
    
    public synchronized Integer get(){
        while(queue.isEmpty()){
        	System.out.println("is empty,wait!");
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return queue.poll();
    }
    public static void main(String[] args) {
    	Lesson2Two queue = new Lesson2Two();
        Thread add1 = new Thread(new TestThreadAdd(queue));
        Thread add2 = new Thread(new TestThreadAdd(queue));
        Thread add3 = new Thread(new TestThreadAdd(queue));
        Thread add4 = new Thread(new TestThreadAdd(queue));
        Thread add5 = new Thread(new TestThreadAdd(queue));
        Thread get1 = new Thread(new TestThreadGet(queue));
        Thread get2 = new Thread(new TestThreadGet(queue));
        Thread get3 = new Thread(new TestThreadGet(queue));
        Thread get4 = new Thread(new TestThreadGet(queue));
        Thread get5 = new Thread(new TestThreadGet(queue));
        add1.start();
        add2.start();
        add3.start();
        add4.start();
        add5.start();
        get1.start();
        get2.start();
        get3.start();
        get4.start();
        get5.start();
    }
}

class TestThreadAdd implements Runnable{
    private Lesson2Two queue;
    
    public TestThreadAdd(Lesson2Two queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            queue.add(i);
            System.out.println("add~~~~ "+ i);
        }
    }
}

class TestThreadGet implements Runnable{
    private Lesson2Two queue;
    public TestThreadGet(Lesson2Two queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            queue.get();
            System.out.println("get~~~~ "+ i);
        }
    }
}