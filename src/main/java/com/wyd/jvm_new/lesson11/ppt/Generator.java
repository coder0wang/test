package com.wyd.jvm_new.lesson11.ppt;

import java.io.File;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class Generator{ 
	 public static void main(String args[]) throws Exception { 
		 ClassReader cr = new ClassReader("geym.jvm.ch10.asm.Account"); 
		 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES); 
		 AddSecurityCheckClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw); 
		 cr.accept(classAdapter, ClassReader.SKIP_DEBUG); 
		 byte[] data = cw.toByteArray(); 
		 File file = new File("bin/geym/jvm/ch10/asm/Account.class"); 
		 FileOutputStream fout = new FileOutputStream(file); 
		 fout.write(data); 
		 fout.close(); 
	 } 
}
