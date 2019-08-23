package com.coder.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class NumSum2 {


    public static int[] twoSum(int[] nums, int target) {

        
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        Set<Entry<Integer, Integer>> set = map.entrySet();
        
        for (Entry<Integer, Integer> temp : set) {
            int findNum = target - temp.getKey();
            if(findNum<1){
                continue;
            }
            Integer numInMap = map.get(findNum);
            if(numInMap!=null){
                int start = temp.getValue();
                int end = numInMap;
                if(numInMap<temp.getValue()){
                    start = numInMap;
                    end = temp.getValue();
                }
                return new int[]{start,end};
            }
        }
        
        return null;
        
    
    }

    public static void main(String[] args) {
//         int[] nums ={2, 7, 11, 15};
//         int target = 9;

//        int[] nums = {3, 2, 4};
//        int target = 6;
        
        int[] nums = {3, 3};
      int target = 6;

        int[] result =  twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
