package com.coder.leetcode;
class NumSum {
    
    public static void sort(int[] nums,int start,int end){
        
        if(start<end){
            
            int temp = nums[start];
            int left = start;
            int rigth = end;
            
            while(left<rigth){
                
                while(left<rigth&&temp<=nums[rigth]){
                    rigth --;
                }
                if(left<rigth){
                    nums [left++]= nums[rigth];
                }
                
                while(left<rigth&&temp>=nums[left]){
                    left ++;
                }
                if(left<rigth){
                    nums [rigth--]= nums[left];
                }
            }
            nums[left] = temp;
            sort(nums,start,left);
            sort(nums,left+1,end);
        }
        
    }
    
    public static int[] twoSum(int[] nums, int target) {
       
        int[] numOrg = new int[nums.length];
        numOrg = nums.clone();
        
        sort(nums,0,nums.length-1);
         
        int endSign = nums.length-1;
        
        
        int[] returnInts = new int[2];
        
            
            int left = 0;
            int right = endSign;
            
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
            
            boolean isLeft = false;
            
            for(int i = 0;i<numOrg.length;i++){
                
                if(numOrg[i]==nums[left]&&!isLeft){
                    returnInts[0] = i;
                    isLeft= true;
                    System.out.println( "left  " + i);
                }else if(numOrg[i]==nums[right]){
                    returnInts[1] = i;
                    System.out.println( "right  " + i);
                }
            }
        
        return returnInts;
    }
    
    
    public static int[] twoSum2(int[] nums, int target) {
        int[] map = new int[16100];
        for(int i=0;i<nums.length-1;i++){
            map[nums[i]+4]=i+1;
            int comp = (target-nums[i+1])+4;
            if(comp<0)continue;
            if(map[comp]>0){
                return new int[]{map[comp]-1,i+1};
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
//        int[] nums =
//        {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};            
//        int target = 542;
        
        
        int[] nums ={-18, 12, 3, 0};
        int target = -6;
        
//        int[] nums ={3,3};
//        int target = 6;
        
        int[] result =  twoSum2(nums,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
        
    }
}