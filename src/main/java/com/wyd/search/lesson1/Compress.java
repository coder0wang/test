package com.wyd.search.lesson1;


public class Compress {
	int n = 9873456;
	public static void main(String[] args) {
		Compress c = new Compress();
		c.a();
//		c.extractionOfARoot(9873456);
//		System.out.println(Math.sqrt(9873456));
	}
	

	void a (){
		int aa = 128*128*128;
		int aaN = n/aa;
		System.out.println(aaN);
		int a = aaN * aa;
		int aN = n - a;
		int bb = 128*128;
		int bbN = aN/bb;
		System.out.println(bbN);
		int b = bbN *bb;
		int bN = aN - b;
		int cc = 128;
		System.out.println(bN/cc);
		System.out.println(bN%cc);
		
		System.out.println(4*aa);
		System.out.println(90*bb);
		System.out.println(80*cc);
		System.out.println(48);
		
		System.out.println(8388608+1474560+10240+48);
//		int a = 602*128*128;
//		System.out.println("a: "+a);
//		int b = 80*128;
//		int c  = n - a;
//		System.out.println("c: "+c);
//		System.out.println(c/128);
//		System.out.println(c%128);
//		int m = a+ b + 48;
//		System.out.println(m);
	}
	
	
	void extractionOfARoot(int a ){
		int num = 0 ;
		boolean b = true;
		while (b) {
			num ++;
			a = a/2;
			if (a%2!=0) {
				b= false;
			}
		}
		System.out.println(num);
	}
	
	void e(){
		long a = 1;
		for (int i = 0; i < 3142; i++) {
			a = a*2;
			if (a>1484871 ) {
				System.out.println(a);
				System.out.println(i);
				i=5000;
			}
		}
		System.out.println(a);
	}
}
