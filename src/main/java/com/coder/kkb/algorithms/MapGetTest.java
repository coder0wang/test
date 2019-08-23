package com.coder.kkb.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapGetTest {

    
    public static void main(String[] args) {
        
        
        List<String> list = new ArrayList<>();
        list.add("key-aaa");
        list.add("key-bbb");
        list.add("key-ccc");
        
        
        Map<String,String> map = new HashMap<>();
        
        map.put("key-aaa", "aaaaaaaaaa");
        map.put("key-bbb", "bbbbbbbbbb");
        map.put("key-ccc", "cccccccccc");
        
        get1(list, map);
        
        get2(list, map);
        
    }
    
    
    public static void get1(List<String> list,Map<String,String> map){
        long start = System.nanoTime();
        for(String key:list){
            if(map.containsKey(key)){
                map.get(key);
                //TODO 
                
            }
        }
        long end = System.nanoTime();
        System.out.println( end - start );
    }
    
    public static void get2(List<String> list,Map<String,String> map){
        long start = System.nanoTime();
        
        for(String key:list){
            String value = map.get(key);
            if(value!=null){
                //TODO
            }
        }
        
        long end = System.nanoTime();
        System.out.println( end - start );
    }
}
