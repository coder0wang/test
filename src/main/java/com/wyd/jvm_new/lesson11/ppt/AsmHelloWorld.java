package com.wyd.jvm_new.lesson11.ppt;

import org.objectweb.asm.Opcodes;

public class AsmHelloWorld extends ClassLoader implements Opcodes {


    public AsmHelloWorld() {
        super();
    }

    public AsmHelloWorld(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> defineClass(String name, byte[] b){
        return super.defineClass(name, b, 0, b.length);
    }

}
