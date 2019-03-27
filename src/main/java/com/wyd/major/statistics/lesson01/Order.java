package com.wyd.major.statistics.lesson01;

public class Order {
	
	public static int[] order(int[] orgInts){
		for (int i = 0; i < orgInts.length; i++) {
			for (int j = 0; j<orgInts.length -i-1; j++) {
				if(orgInts[j+1]<orgInts[j]){
					int temp = orgInts[j+1];
					orgInts[j+1] = orgInts[j];
					orgInts[j] = temp;
					
				}
			}
		}
		return orgInts;
	}
	
	public static void main(String[] args) {
		int[] orgInts = {225,232,232,245,235,245,270,225,240,240,217,195,225,185,200,220,200,210,271,240,220,230,215,252,225,220,206,185,227,236};
		
		System.out.println("总人数是："+orgInts.length);
		outInts(order(orgInts));
		/**
		 * 范围到 179.5 279.5 ， 和位100 每个段位区域是20
		 * 179.5-199.5-219.5-239.5-259.5-279.5 
		 * a,b,c,d,e
		 */
		int a = 0,b = 0,c = 0,d = 0,e  = 0;
		for (int i = 0; i < orgInts.length; i++) {
			if(orgInts[i]<=199){
				a+=1;
			}else if(orgInts[i]<=219){
				b+=1;
			}else if(orgInts[i]<=239){
				c+=1;
			}else if(orgInts[i]<=259){
				d+=1;
			}else if(orgInts[i]<=279){
				e+=1;
			}
		}
		System.out.println(a+" "+b+" "+c+" "+d+" "+e);
		
		/**
		 * int 没有小数点，中位数上下边缘有误差
		 */
		int center = orgInts[orgInts.length/2];
		int Q1 = orgInts[orgInts.length/4+1];
		int Q3 = orgInts[orgInts.length-(orgInts.length/4)];
		int IQR = Q1 - Q3;
		int topError = Q1 - IQR - (IQR/2);
		int buttonError = Q3 + IQR + (IQR/2);
		System.out.println("center" + center);
		System.out.println("Q1 "+Q1);
		System.out.println("Q3 "+Q3);
		System.out.println("IQR "+IQR);
		System.out.println("topError "+topError);
		System.out.println("buttonError "+buttonError);
		
		int[] ints2 = {93,62,51,93,75,82,93,62,65,51};
		int sum = 0;
		for (int i = 0; i < ints2.length; i++) {
			sum +=ints2[i];
		}
		System.out.println(sum);
		outInts(order(ints2));
	}
	/**
	 * 输出数组
	 */
	public static void outInts(int [] is){
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i]+",");
		}
		System.out.println();
	}

}
