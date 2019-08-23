package com.coder.kkb.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MapPrint {
    
   
    
    public static void printMap(){
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            map.put("key"+i, "value"+i);
        }
        print1(map);
        print2(map);
    }
    
    public static void main(String[] args) {
        printMap();
    }
    
    
 public static void print1(Map<String, String> map){
        
        long start = System.nanoTime();
        
        for(String key : map.keySet()){
            
            map.get(key);
            
        }
        
        long end = System.nanoTime();
        
        System.out.println( end - start );
    }
    
    
    
    public static void print2(Map<String, String> map){
        
        long start = System.nanoTime();
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            entry.getValue();
        }
        
        long end = System.nanoTime();
        System.out.println( end - start );
    }
    
}
