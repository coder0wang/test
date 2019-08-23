package com.coder.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FourNumSum_18 {

    
    
    public static void fastSort(int[] nums , int start, int end){
        
        if(start<end){
            
            int temp = nums[start];
            int i = start;
            int j = end;
            
            while(i<j&&temp<nums[j]){
                j--;
            }
            if(i<j){
                nums[i++] = nums[j];
            }
            
            while(i<j&&temp>nums[i]){
                i++;
            }
            if(i<j){
                nums[j--] = nums[i];
            }
            
            nums[i] = temp;
            fastSort(nums, start, i);
            fastSort(nums, i+1, end);
        }
        
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        
        //先排序再算数
        
//        int[] oldNums = nums;
            
        fastSort(nums, 0, nums.length-1);
        
        List<List<Integer>> returnList = new ArrayList<>();
        
        int s0 = 0;
        int s1 = 1;
        int e0 = nums.length-1;
        int e1 = nums.length-2;
        /**
         * s和e记录，该移动0还是1
         * false 移动0
         * true 移动1
         * 
         */
        boolean s = false;
        
        
        //返回集合
        
        
        
        return null;
    }
    
    
    public static void main(String[] args) {
       int[] nums = {1, 0, -1, 0, -2, 2};
       int target = 0;
       
       List<List<Integer>> list = fourSum(nums, target);
       Tool.printList(list);
    }
    
}
