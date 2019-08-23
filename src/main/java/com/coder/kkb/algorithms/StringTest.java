package com.coder.kkb.algorithms;

public class StringTest {

    public static void main(String[] args) {

        a();
        
        b();
    }

    public static void a() {
        long start = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1024; i++) {
            sb.append("a");
        }

        long end = System.nanoTime();

        System.out.println( end - start);
    }

    
    
    
    
    public static void b() {
        long start = System.nanoTime();

        StringBuilder sb = new StringBuilder(1024);

        for (int i = 0; i < 1024; i++) {
            sb.append("b");
        }

        long end = System.nanoTime();

        System.out.println(end - start);
    }
    
}
