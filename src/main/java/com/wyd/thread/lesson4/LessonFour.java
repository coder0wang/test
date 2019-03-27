package com.wyd.thread.lesson4;
import java.util.Arrays;
/**
 * 

* @Title: LessonFour.java 

* @Package com.wyd.thread.lesson4 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2015-10-11 下午11:17:39 

* @version V1.0
 */



public class LessonFour<T> {
    Object[] data;
    private int capacity;
    private int size;
    public LessonFour()
    {
    	capacity=16;
    	size=0;
    	data=new Object[capacity];
    }
    public void ensureCapacity(){
    	capacity=capacity*2;
    	data=Arrays.copyOf(data, capacity);
    }
    public void push(T ele)
    { 
    	if(size<capacity)
    	{
    		data[size++]=ele;
    	}
    	else
    	{
    		ensureCapacity();
    		data[size++]=ele;
    	}
    }
    public void pop()
    {
    	if(size>0)
    	{
    		System.out.println(data[size-1]);
    		data[--size]=null;
    	}
    	else
    	{
    		System.out.println("堆空啦!!!");
    	}
    }
    boolean isEmpty()
    {
    	return size==0;
    }
    

    
    public static void main(String[] args)
    {
    	LessonFour<Integer> fcStack=new LessonFour<Integer>();
    	for(int i=0;i<10;i++)
    	{
    		fcStack.push(i);
    	}
    	for(int i=0;i<10;i++)
    	{
    		fcStack.pop();
    	}
    	fcStack.pop();
    }
}
