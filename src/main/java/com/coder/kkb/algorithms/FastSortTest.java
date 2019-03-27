package com.coder.kkb.algorithms;
/**
 */
public class FastSortTest {

	
	static int[]  orgInts = {5,11,2,9,4,0,12,8,6,10,1,3};
	
	public static void sort(int ints[] ,int begin ,int end){
		
		if(begin<end){
			//中位数
			int num = orgInts[begin];
			
			int i = begin;
			int j = end;
			
			while(i<j){
				
				while(i<j&&num<orgInts[j]){
					j--;
				}
				
				if(i<j){
					orgInts[i++] = orgInts[j];
				}
				
				while(i<j&&num>orgInts[i]){
					i++;
				}
				
				if(i<j){
				orgInts[j--] = orgInts[i];
				}
			}
			
			ints[i] = num;
//			printInt(orgInts);
			sort(orgInts,begin,i);
			sort(orgInts,i+1,end);
		}
	}
	
	public static void main(String[] args) {
		printInt(orgInts);
		sort(orgInts, 0, orgInts.length-1);
		printInt(orgInts);
	}
	
	public static void printInt (int[]  orgInts){
		System.out.println();
		for (int i = 0; i < orgInts.length; i++) {
			System.out.print(orgInts[i]+",");
		}
	}
}
