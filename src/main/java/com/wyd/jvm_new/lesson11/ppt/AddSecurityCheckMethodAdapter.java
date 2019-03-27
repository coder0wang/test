package com.wyd.jvm_new.lesson11.ppt;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class AddSecurityCheckMethodAdapter extends MethodVisitor { 
	 public AddSecurityCheckMethodAdapter(MethodVisitor mv) { 
		 super(Opcodes.ASM5,mv); 
	 } 
	 public void visitCode() { 
		 visitMethodInsn(Opcodes.INVOKESTATIC, "geym/jvm/ch10/asm/SecurityChecker", 
			"checkSecurity", "()Z"); 
		 super.visitCode();
	 } 
}
