package com.coder.kkb.jvm;

public class JmmTest extends Thread {
    private volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag);
        System.out.println("我停了"+ System.currentTimeMillis());
    }

    public static void main(String[] args) throws Exception {
        JmmTest vt = new JmmTest();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
    }
}