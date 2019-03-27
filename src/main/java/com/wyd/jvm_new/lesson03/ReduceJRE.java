package com.wyd.jvm_new.lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
/**
 * 

* @Title: ReduceJRE.java 

* @Package com.wyd.jvm_new.lesson03 

* @Description: 第三课 压缩rt

* @author Coder 

* @date 2016-9-25 下午11:32:10 

* @version V1.0
 */
public class ReduceJRE {

	public static void main(String[] args) throws Exception {
		//文件路径
		String txtPath = "F:/Program Files/Java/jdk1.7.0_15/jre/lib/classlist_test";
		
		String rtJarPath= "F:/Program Files/Java/jdk1.7.0_15/jre/lib/rt.jar";
		
		List<String> depencyClass = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(txtPath)));
		String templine = br.readLine();
		// load all the dependency class and store them in a array list;
		while (templine != null) {
			int end = templine.lastIndexOf("from");
			int begin = templine.lastIndexOf("[Loaded") + 7;
			String className = templine.substring(begin, end).replace(".", "/")
					.trim();
			depencyClass.add(className);
			templine = br.readLine();
		}
		JarFile zipIn = new JarFile(rtJarPath);
		InputStream readin = null;
		JarOutputStream jos = new JarOutputStream(
				new FileOutputStream("rt.jar"));
		JarInputStream jis = new JarInputStream(new FileInputStream(rtJarPath));
		JarEntry entry = jis.getNextJarEntry();
		while (entry != null) {
			String name = entry.getName();
			// remove the .class suffix.
			name = name.substring(0, name.lastIndexOf("."));
			if (depencyClass.contains(name)) {
				// put an entry record and write the binary data
				jos.putNextEntry(entry);
				readin = zipIn.getInputStream(entry);
				byte[] temp = new byte[4096];
				int count = readin.read(temp);
				while (count != -1) {
					jos.write(temp, 0, count);
					count = readin.read(temp);
				}
				readin.close();
			}
			entry = jis.getNextJarEntry();
		}
		jis.close();
		jos.close();
	}
}