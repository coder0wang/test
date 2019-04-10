package com.coder.leetcode;

public class NumSum2 {
    
    public static int[] twoSum(int[] nums, int target) {
        
         
            int left = 0;
            int right = nums.length-1;
            
            while(left<right){
            
                int sum = nums[left]+nums[right];
                System.out.println(left + "    "+ right + "   "+sum);
                if(sum == target){
                    break;
                }else if(sum<target){
                        left ++;
                    continue;
                }else if(sum>target){
                        right--;
                    continue;
                }
                
            }
            int[] returnInts = {left,right};
        return returnInts;
    }

    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int target = 9;
        
        twoSum(nums,target);
}
}
