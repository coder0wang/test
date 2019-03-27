package com.wyd.jvm_new.lesson10;
/**
 * 

* @Title: Test.java 

* @Package com.wyd.jvm_new.lesson10 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-11-20 下午11:44:20 

* @version V1.0
 */
public class Test implements ITest{

	/**
	 * id
	 */
	private  String id; 
	/**
	 * 名称
	 */
	private String name;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main");
	}

	@Override
	public String test(int a ) {
		System.out.println("~~~~~~~~~");
		return String.valueOf(a);
	}

}
