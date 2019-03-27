package com.wyd.jvm_new.lesson6;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader {

	private String fileName;

	protected Class<?> findClass(String className)
			throws ClassNotFoundException {

		Class<?> clazz = this.findLoadedClass(className);
		if (null == clazz) {

			try {

				String classFile = getClassFile(className);
				FileInputStream fis = new FileInputStream(classFile);
				FileChannel fileC = fis.getChannel();

				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				WritableByteChannel outC = Channels.newChannel(baos);
				ByteBuffer buffer = ByteBuffer.allocate(1024);

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
				byte[] bytes = baos.toByteArray();
				clazz = defineClass(className, bytes, 0, bytes.length);

			} catch (FileNotFoundException e) {

				// e.printStackTrace();

			} catch (IOException e1) {

			}

		}
		return clazz;

	}

	protected synchronized Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {

		// First, check if the class has already been loaded
		Class<?> re = findClass(name);

		if (re == null) {

			return super.loadClass(name, resolve);

		}
		return re;

	}
	public MyClassLoader(String fileName) {
		this.fileName = fileName;

	}
	private String getClassFile(String className) {
		return fileName + className.replace(".", "/") + ".class";
	}
}