package com.wyd.jvm.lesson1;

public class Snippet {
////	private int a=0xDada_Cafe;
//		private float b=0x1.fffffeP+127f;
//		private float c=1996;
////		private float d=1996.3;
////		private int f=9999e2;
//		private double g=33e2;
//		private float h=0x1.fffep-12f;
//		int i = 0xDada;
////		private float i=1.fffep-12f;
////		private long p=0b1_1_1_0_1;
////		private long q=0b1_1_1_0_2;
	
		public static void main(String[] args) {
			Test test = new Test();
			test.printf(100.2f);
//			String a = Integer.toBinaryString(-99);
//			System.out.println("  "+a);
//			String n = Integer.toBinaryString(-6);
//			System.out.println("  "+n);
//			test.tenToTwo(105);
//			System.out.println(9^5);
			
//			System.out.println(Integer.toBinaryString(Float.floatToIntBits(100.2f)));
			
		}
}
class  Test{
	public void print2(int num){
		for(int i=0;i<32;i++){
			int t=(num & 0x80000000>>>i)>>>(31-i);
			System.out.print(t);
		}
	}
	//3 题
	public void printf(float num){
		int l = Float.floatToIntBits(num);
		for (int i = 0; i < 32; i++)
		{
			int x = (l & 0x80000000>>>i) >>> (31-i);
			System.out.print(x);
		}
		System.out.println();
	}
	public void tenToTwo(int i){
		System.out.println("十进制为: " + i);
		System.out.println("二进制为: " + Integer.toBinaryString(i));
	}
	
	
	
}

