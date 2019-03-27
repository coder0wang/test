package com.wyd.jvm_new.lesson11.ppt;

import java.lang.reflect.InvocationTargetException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
/**
 * 

* @Title: Load.java 

* @Package com.wyd.jvm_new.lesson11.ppt 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-11-27 下午10:40:25 

* @version V1.0
 */
public class Load  implements Opcodes{

	
	public static void load() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);  
		cw.visit(V1_7, ACC_PUBLIC, "Example", null, "java/lang/Object", null);  
		MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null,  null);  
		mw.visitVarInsn(ALOAD, 0);  //this 入栈
		mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);  
		mw.visitInsn(RETURN);  
		mw.visitMaxs(0, 0);  
		mw.visitEnd();  
		mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main",  "([Ljava/lang/String;)V", null, null);  
		
		mw.visitCode();
		Label l0 = new Label();
		mw.visitLabel(l0);
//		mw.visitVarInsn(ALOAD, 0);
//		cw.visitField(Opcodes.F_APPEND, "a", "I", null, new Integer(6)).visitEnd();
//		cw.visitField(Opcodes.F_APPEND, "b", "I", null, new Integer(7)).visitEnd();
//		mw.visitVarInsn(SIPUSH, 6);
//		mw.visitVarInsn(ILOAD, 2);
		mw.visitVarInsn(BIPUSH,6);
		mw.visitVarInsn(ISTORE, 1);
		mw.visitVarInsn(BIPUSH,7);
		mw.visitVarInsn(ISTORE, 2);
		mw.visitVarInsn(ILOAD, 1);
		mw.visitVarInsn(ILOAD, 2);
		mw.visitInsn(IADD);
		mw.visitInsn(ICONST_3);
		mw.visitInsn(IMUL);
		mw.visitInsn(ICONST_3);
		mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//		mw.visitVarInsn(ILOAD, 3);
		mw.visitVarInsn(GETFIELD,1);
//		mw.visitLdcInsn("a");
//		mw.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
//		mw.visitVarInsn(INVOKEVIRTUAL);
		mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//		 mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//         mw.visitTypeInsn(NEW, "java/lang/StringBuilder");
//         mw.visitInsn(DUP);
//         mw.visitLdcInsn(">>>>>>>>>>testList > list.size = ");
//         mw.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false);
//         mw.visitVarInsn(ILOAD, 3);
//         mw.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;",
//                 false);
//         mw.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
//         mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
         
         
		mw.visitInsn(RETURN);  
		mw.visitMaxs(2,4);  
		mw.visitEnd();  
		byte[] code = cw.toByteArray();  
		MyClassLoader loader = new MyClassLoader();  
		Class exampleClass = loader.defineClass("Example", code);  
		exampleClass.getMethods()[0].invoke(null, new Object[] { null }); 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			load();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
