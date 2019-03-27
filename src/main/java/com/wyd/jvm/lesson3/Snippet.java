package com.wyd.jvm.lesson3;

public class Snippet {
	public static void main(String[] args) {
		byte[] b=new byte[10*1024*1024];
		System.out.print("Xmx=");
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
		System.out.print("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
		System.gc();
		System.out.print("Xmx=");
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
		System.out.print("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
		
	}
}

