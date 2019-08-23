package com.coder.kkb.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    static final int hash(Object key) {
        int h  ;
        h = key.hashCode();
        System.out.println(" >>>  "+Integer.toBinaryString(h));
        System.out.println(" >>>                  "+Integer.toBinaryString(h >>> 16));
        System.out.println(" >>>  "+ Integer.toBinaryString(((h) ^ (h >>> 16))));
        System.out.println(">>>>>");
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    public static void hashTest(){

        hash("aaaaaaaaaaaa");
        hash("bbbbbbbbbbbb");
    }
    
    
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//        long start = System.nanoTime();
//        
//        long end = System.nanoTime();
//        
//        System.out.println(start - end);
        
        
//        System.out.println(Integer.toBinaryString(234923423>>2));
//        System.out.println(Integer.toBinaryString(234923423>>>2));
    }
    
}
