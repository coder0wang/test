package com.coder.kkb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
/**
 * 
 * 此类描述的是：  java 8相关的使用
 * @author: Coder_Wang 
 * @version: 2018年12月13日 下午9:26:53
 */


public class Java_8 {
	
	public static void main(String[] args) {
		testLambda4();
	}
	/** -------<Lambda>-------**/
	
	/**
	 * 不变的对象
	 */
	public static void noChange(){
		int[] ints ={1,2,3,4,5,6,7,8,9,0};
		Arrays.stream(ints).map((x)->x=x+10).forEach(System.out::println);
		System.out.println();
		Arrays.stream(ints).forEach(System.out::println);
	}
	
	
	public static void testLambda1(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start...old ");
			}
		});
		t.start();
		
		Thread tL = new Thread(() -> System.out.println("start...Lambda1"));
		tL.start();
	}
	
	public static void testLambda2(){
		List<String> list = Arrays.asList(new String[]{"h","e","d","n"});
		Collections.sort(list, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		
		Collections.sort(list, (String a, String b) -> {
		    return b.compareTo(a);
		});
		System.out.println(JSONObject.toJSON(list));
		Collections.sort(list, (String a, String b) -> b.compareTo(a));
		/**
		 * 如果只有一行代码可以省去return 大括号等
		 */
		Collections.sort(list, (a, b) -> b.compareTo(a));
	}
	
	public static void testLambda3(){
		List<String> list = Arrays.asList(new String[]{"AShjDhe","Egdwer","Test","Java"});
		
		List<String> lowerCaseList = new ArrayList<>();
		
		for (String value:list) {
			lowerCaseList.add(value.toLowerCase());
		}
		
		List<String> lowerCaseListL =  list.stream().map(name ->name.toLowerCase()).collect(Collectors.toList());
		                                                                       
	}
	
	public static void testLambda4(){
		List<Integer> nums = Arrays.asList(new Integer[]{1,null,3,4,null,6,9});
		long count =  nums.stream().filter(num -> num != null).count();
		System.out.println(count);
	}
	/** -------<Lambda>-------**/
}
