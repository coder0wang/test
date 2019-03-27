package com.wyd.algorithm.lesson1;
/**
 * 

* @Title: SortTest.java 

* @Package com.wyd.algorithm.lesson1 

* @Description: 排序测试类 

* @author Coder 

* @date 2016-6-10 下午12:55:57 

* @version V1.0
 */
public class SortTest {
	static int[]  orgInts = {5,11,2,9,4,0,12,8,6,10,1,3};
	public static void printInt (int[]  orgInts){
		System.out.println();
		for (int i = 0; i < orgInts.length; i++) {
			System.out.print(orgInts[i]+",");
		}
	}
	
	
	public static void kpT(int[] ints,int begin,int end){
		if(begin<end){
			
			int num = ints[begin];
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
			
			kpT(ints,begin,i);
			kpT(ints,i+1,end);
			
		}
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortTest test = new SortTest();
//		test.insertSort();
//		test.bubbleSort();
//		test.testMergeA();
		printInt(orgInts);
		SortTest.kpT(orgInts,0,orgInts.length-1);
		printInt(orgInts);
	}
	
	
	/**
	 * 快速排序
	 */
	public void fastSort(int[] orgInts ,int l ,int r){
		if (l < r)
	    {
		 int i=l,j=r;
		 int num = orgInts[l];
		 while (i<j) {
			
			 while(i<j&&orgInts[j]>=num){
				 j--;
			 }
			 System.out.println("j>>>> "+j);
			
			 if(i<j){
				 orgInts[i++] =orgInts[j];
			 }
			 printInt(orgInts);
			 while(i<j&&orgInts[i]<num){
				 i++;
			 }
			 System.out.println("i>>>> "+i);
			 if(i<j){
				 orgInts[j--] =orgInts[i];
			 }
			 printInt(orgInts);
			 System.out.println("i>>>> "+i);
		}
		 orgInts[i] = num;
		 printInt(orgInts);
		 fastSort(orgInts,l,i-1);
		 fastSort(orgInts,i+1,r);
	    }
	}

	/**
	 * 插入排序
	 */
	public void insertSort(){
		outInts(orgInts);
		for (int i = 1; i < orgInts.length; i++) {
			for (int j = i-1; j >=0; j--) {
				System.out.println(orgInts[j+1]+"   "+orgInts[j]);
				if(orgInts[j+1]<orgInts[j]){
					int temp = orgInts[j+1];
					orgInts[j+1] = orgInts[j];
					orgInts[j] = temp;
					System.out.println("交换 "+orgInts[j+1]+"   "+orgInts[j]);
					outInts(orgInts);
				}else{
					break;
				}
			}
			outInts(orgInts);
		}
	}
	/**
	 * 冒泡排序
	 */
	public void bubbleSort(){
		outInts(orgInts);
		for (int i = 0; i < orgInts.length; i++) {
			for (int j = 0; j < orgInts.length-i-1; j++) {
				System.out.println(orgInts[j+1]+"   "+orgInts[j]);
				if(orgInts[j+1]<orgInts[j]){
					int temp = orgInts[j+1];
					orgInts[j+1] = orgInts[j];
					orgInts[j] = temp;
					System.out.println("交换 "+orgInts[j+1]+"   "+orgInts[j]);
					outInts(orgInts);
				}
			}
			outInts(orgInts);
		}
	}
	
	/**
	 * 归并排序
	 */
	
	public void mergeSort(){
		int[] a = new int[] { 4, 3, 6, 1, 2, 5 };
        mergeSort(a, 0, 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
	}
	public void testMergeA(){
		int[] aaa = {2, 7, 8, 3, 1 , 3, 1, 6, 9, 0, 5, 4 };
		sortA(aaa,0,aaa.length-1,111);
		outInts(aaa);
	}
	public void sortA(int[] nums, int start  ,int end,int sign){
//		outInts(nums);
		int center = (start+end)>>1;
        if(start<end){
        	System.out.println("start : " + start + "  end: "+end + "  sign:  " +sign);
        	//左边
        	sortA(nums,start,center,1);
        	//右边
        	sortA(nums,center+1,end,0);
        	//合并
        	mergeA(nums,start,center,end);
        }
	}
	/**
	 * 
	 * @param nums
	 * @param startNum1
	 * @param startNum2
	 * @param endNum2
	 * public void mergeA(int nums[], int startNum1 ,int endNum1 ,int startNum2 , int endNum2){
	 * ,int endNum1 没有用参数就不用传了
	 */
	public void mergeA(int[] nums, int startNum1  ,int startNum2 , int endNum2){
		System.out.println(" m1:" + startNum1 +" m2: "+ startNum2 +" m3:" +endNum2);
		int[] temp = new int[endNum2 - startNum1 +1];
		int i= 0;
		int as = startNum1,
			bs = startNum2+1;
		while(as<=startNum2&&bs<=endNum2){
			int a  = nums[as];
			int b = nums[bs];
			if(a<b){
				temp[i++] =nums[as++];
			}else {
				//两个相当就按照b小处理
				temp[i++] =nums[bs++];
			}
		}
		//最后剩下的放入数字
		//if(as<= startNum2)
		while(as<= startNum2){
			temp[i++] =nums[as++];
		}
		while(bs<= endNum2){
			temp[i++] =nums[bs++];
		}
		outInts(temp);
		System.arraycopy(temp, 0, nums, startNum1, temp.length);
		outInts(nums);
	}
	// private static long sum = 0;
    /**
     * <pre>
     * 二路归并
     * 原理：将两个有序表合并和一个有序表
     * </pre>
     * 
     * @param a
     * @param s
     * 第一个有序表的起始下标
     * @param m
     * 第二个有序表的起始下标
     * @param t
     * 第二个有序表的结束小标
     * 
     */
    private static void merge(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }
    /**
     * 
     * @param a
     * @param s
     * @param len
     * 每次归并的有序集合的长度
     */
    public static void mergeSort(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        // -------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        // ------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge(a, s, s + len, (len << 1) + s - 1);
        }
        // -------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            merge(a, size - c - 2 * len, size - c, size - 1);
        // -------递归执行下一趟归并排序------//
        mergeSort(a, 0, 2 * len);
    }
	/**
	 * 输出数组
	 */
	public void outInts(int [] is){
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i]+",");
		}
		System.out.println();
	}
	
	
}
