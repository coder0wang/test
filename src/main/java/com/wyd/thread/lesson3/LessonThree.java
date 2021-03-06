package com.wyd.thread.lesson3;
/**
 * 

* @Title: Test.java 

* @Package com.wyd.thread.lesson3 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2015-9-28 上午12:15:56 

* @version V1.0
 */
public class LessonThree {

    protected long l = -1l;

    public static void main(String[] args) {
//        System.out.println(toBinary(-1l));
//        System.out.println(toBinary(1l));
        LessonThree t = new LessonThree();
        Worker w1 = new Worker(t);
        Worker2 w2 = new Worker2(t);
        w1.setDaemon(true);
        w2.setDaemon(true);
        w1.start();
        w2.start();
        while (true) {
            if (t.l != -1l && t.l != 1l) {
                System.out.println(toBinary(t.l));
                System.out.println("l的写不是原子操作");
                break;
            }
        }
    }

    private static String toBinary(long l) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(l));
        while (sb.length() < 64) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}

class Worker extends Thread {

    public Worker(LessonThree t) {
        this.t = t;
    }

    private LessonThree t;

    public void run() {
        while (true) {
            t.l = -1l;
        }
    }
}

class Worker2 extends Thread {

    public Worker2(LessonThree t) {
        this.t = t;
    }

    private LessonThree t;

    public void run() {
        while (true) {
            t.l = 1l;
        }
    }

	}