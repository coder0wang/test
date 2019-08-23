package com.coder.kkb.algorithms;


public class BigO {
	static Integer[]  orgInts = {5,11,2,9,4,0,12,8,6,10,1,3};
	
	/**
	 * O(1)
	 * 常数阶，无论数据多大只需要一次
	 */
	Integer getO1(){
		return orgInts[0];
	}
	/**
	 * O(n)
	 * 线性阶，运算次数等同数据大小（案例的最坏评估）
	 */
	Integer getOn(){
		for (int i = 0; i < orgInts.length; i++) {
			if(orgInts[i]==10){
				return orgInts[i];
			}
		}
		return null;
	}
	/**
	 * O(n²/n^2)
	 * 如果是三层循环就是n的三次方，n次就是n次方
	 */
	Integer getN2(){
		for (int i = 0; i < orgInts.length; i++) {
			for (int j = orgInts.length -1 ; j >= 0; j--) {
				if(orgInts[i]==orgInts[j]){
					return orgInts[i];
				}
			}
		}
		return null;
	}
	
	
	/**
	 * O(2^n)
	 * 表示数字每增大一次运算会增大两倍
	 */
	Integer get2n(int number)
	{
	    if (number <= 1){ 
	    	return number;
	    }
	    return get2n(number - 2) + get2n(number - 1);
	}
	
	/**
	 * O(logn)
	 */
	Integer getLogN(){
		int n = 1000;
		int number = 1;
		// 语句执行logn次
		while (number < n) { 
		  /**
		   * 这里的2是log的底数
		   * 底数在大O符号中是省去的
		   */
		  number *= 2;
		}
		return number;
	}
}
