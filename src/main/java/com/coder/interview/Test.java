package com.coder.interview;

import java.math.BigDecimal;

public class Test {

	
	public static void main(String[] args) {
		printResult(12, 1);
	}

	/**
	 * 
     * 此方法描述的是：  
     * num 需要开方的值
     * num2 误差范围
     * @author: Coder_Wang 
     * @version: 2018年9月13日 下午8:47:57
     * 
	 */
	public static void printResult(int num,double num2){
		//计算位数
		int bit = 0;
		//个位的结果
		int result = getResultBy0(num, 0, bit);
		int numBack = result *result;
		
		//绝对值大于误差的继续下一位递归
		while(num-numBack>num2||numBack-num>num2){
			if(numBack-num>num2){
				result--;
			}
			bit ++;
			result = getResultBy0(num, result, bit);
		}
		System.out.println(result);
	}
	/**
	 * 
     * 此方法描述的是： 
     * num 要开方的值
     * num2 开出来的值
     * num3 需要确认的位数  0 是个位, 1位小数点后一位 2位后两位 ....
     * @author: Coder_Wang 
     * @version: 2018年9月13日 下午8:56:19
	 */
	public static int getResultBy0(double num,double num2,int num3){
		int result = 0 ;
		//第一次开方
		if(num2==0){
			for (int i = 2; i < num/2; i++) {
				int tempResult = i*i;
				if(tempResult<num){
					continue;
				}else{
					result = i;
					break;
				}
			}
		}else{
			//开小数点后的位数
			
			//从1 到9 循环
			int temp = num3 *10;
			num2 = num2*temp;
			num = num *temp*temp;
			for (int i = 1; i < 10; i++) {
				//小数点后加的值 例如 3.1/ 3.2
				num2 += i;
				int tempResult = doubleM(num2,num2);
				if(tempResult<num){
					continue;
				}else{
					result = i;
					break;
				}
			}
		}
		
		
		return result;
	}
	//double 相乘方法
	public static int doubleM(double a, double b){
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		 BigDecimal b1 = new BigDecimal(Double.toString(b)); 
		 BigDecimal result = a1.multiply(b1);// 相乘结果
//		 System.out.println(result);
		 BigDecimal one = new BigDecimal("1");
		 int returnV = result.divide(one,2,BigDecimal.ROUND_HALF_UP).intValue();
		 return returnV;
	}
	
	
	
}
