package com.wyd.jvm.lesson6;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class HelloMain {
	public static final String CLASSPATH = "G:/myeclipse/com.wyd/jvm Maven Webapp/";

	public static void main(String[] args) {
		String version = Worker.doit();
		System.out.println(version);
		MyClassLoader mcl = new MyClassLoader(CLASSPATH);
		try {
			Class workerClass = mcl.findClass("com.wyd.jvm.lesson6.Worker");
			Object instance = workerClass.newInstance();
			Method doit = workerClass.getDeclaredMethod("doit", null);
			version = (String) doit.invoke(instance, null);
			System.out.println(version);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyClassLoader extends ClassLoader {

	private String basePath;

	public MyClassLoader(String baseDir) {
		super(null);
		this.basePath = baseDir;
	}

	public Class findClass(String className) throws ClassNotFoundException {
		Class clazz = this.findLoadedClass(className);
		try {
			byte[] bytes = loadClassBytes(className);
			clazz = defineClass(className, bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}

	private byte[] loadClassBytes(String className)
			throws ClassNotFoundException {
		try {
			String classFile = getClassFile(className);
			FileInputStream fis = new FileInputStream(classFile);
			FileChannel fileC = fis.getChannel();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			WritableByteChannel outC = Channels.newChannel(baos);
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			while (true) {
				int i = fileC.read(buffer);
				if (i == 0 || i == -1) {
					break;
				}
				buffer.flip();
				outC.write(buffer);
				buffer.clear();
			}
			fis.close();
			return baos.toByteArray();
		} catch (IOException fnfe) {
			throw new ClassNotFoundException(className);
		}
	}

	private String getClassFile(String className) {
		return basePath + className.replace(".", "/") + ".class";
	}
}
