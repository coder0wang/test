package com.coder.leetcode;

import java.util.List;

/**
 * 此类描述的是：
 * 
 * 
 * @author: Coder_Wang
 * @version: 2019年6月24日 下午9:03:00
 */
public class Tool {
    
    public static void printList(List<List<Integer>> list){
        for (int i = 0; i < list.size(); i++) {
            
            System.out.println("");
            List<Integer> list2 = list.get(i);
            for (int j = 0; j < list2.size(); j++) {
                System.out.print(list2.get(j));
            }
        }
    }

}
