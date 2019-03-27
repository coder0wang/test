package com.coder.kkb.algorithms;

/**
 * 
     * 此类描述的是：  最大子集 
     * @author: Coder_Wang 
     * @version: 2019年2月27日 上午12:36:35
 */
public class Test {

	static int[] nums = { -6, 8, -5, 4, -1, 9, -1};
	
	public static void getMax(){
		
		int max = 0;
//		int begin = 0;
//		int end = 0;
		int sum = 0;
		
		//首次插入
		max = nums[0];
		sum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			int sumTemp = sum + temp;
			if(sumTemp<max){
				sum = sumTemp;
				if(max<temp){
					max = temp;
					sum = temp;
					continue;
				}
				if(sum<temp){
					sum = temp;
				}
				continue;
			}else {
				
				max = sumTemp;
				sum = max;
				if(max<temp){
					max = temp;
					sum =  temp;
					continue;
				}
				continue;
			}
			
//			sum = sumTemp;
		}
		
		System.out.println(max);
//		System.out.println(begin);
//		System.out.println(end);
	}
	
	public static void main(String[] args) {
		getMax();
	}
}
