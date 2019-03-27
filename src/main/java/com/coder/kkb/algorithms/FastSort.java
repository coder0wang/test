package com.coder.kkb.algorithms;
/**
 * 
 * 此类描述的是：  
 * @author: Coder_Wang 
 * @version: 2012年1月13日 上午12:01:52
 */
public class FastSort {
	static int[]  orgInts = {5,11,2,9,4,0,12,8,6,10,1,3};
	public void sort(int ints[],int begin,int end){
		/**
		 * 判断是否长度为1
		 * 注：像这一类判断尽量不要使用等号，防止A>B情况出现（判断错误、并发等）
		 */
		if(begin<end){
			int num = ints[begin];
			//接下来我们要改动的下标，原始的下标不动
			int i = begin;
			int j = end;
			while(i<j){
				while(i<j&&num<ints[j]){
					j--;
				}
				if(i<j){
					ints[i++] = ints[j];
				}
				while(i<j&&num>ints[i]){
					i++;
				}
				if(i<j){
					ints[j--] = ints[i];
				}
			}
			ints[i] = num;
			sort(ints,begin,i);
			sort(ints,i+1,end);
		}
	}
	public static void main(String[] args) {
		printInt(orgInts);
		FastSort fastSort = new FastSort();
		fastSort.sort(orgInts,0,orgInts.length-1);
		printInt(orgInts);
	}
	public static void printInt (int[]  orgInts){
		System.out.println();
		for (int i = 0; i < orgInts.length; i++) {
			System.out.print(orgInts[i]+",");
		}
	}
}
