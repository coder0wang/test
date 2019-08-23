package com.coder.easycoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListRemove {

    static void test(){
        List<String> list = new ArrayList<>();list.add("1");list.add("2");
        Iterator<String> iterator = list.iterator();while(iterator.hasNext())
        {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        
//        for(String item:list){     
//            System.out.println(item);
//            if("2".equals(item)){
//                
//            list.remove(item);         
//            }     
//        }
        
        Map<String,  String> map = new HashMap<>(16);
        map.forEach(
            (key, value) -> {
            System.out.println(key + "：" + value);
        });        
        System.out.println("");
    }
    
    public static void main(String[] args) {
//        test();
        Random random = new Random();
        System.out.println(random.nextInt( 1126 ));
    }
    
}
