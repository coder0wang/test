package com.wyd.jvm_new.lesson6;

import java.lang.reflect.Method;

public class HelloMain {

	public static void main(String[] args) {
		while (true) {
			try {
				MyClassLoader loader = new MyClassLoader("G:/myeclipse/com.wyd/jvm/");
				Class<?> cls = loader.loadClass("com.wyd.jvm_new.lesson6.Worker");
				Object worker = cls.newInstance();
				Method m = worker.getClass().getMethod("doit", String.class);
				m.invoke(worker, "123");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}