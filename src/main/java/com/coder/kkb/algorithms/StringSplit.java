package com.coder.kkb.algorithms;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 此类描述的是：  
 * 字符串切割测试类
 * @author: Coder_Wang 
 * @version: 2019年2月1日 下午3:24:39
 */
public class StringSplit {
	String str = "192.168.10.1";
	String sign = ".";
	int num = 1024;
	public void split(int num){
		long start = System.nanoTime();
		switch (num) {
		case 0:
			jdkSplit();
			break;
		case 1:
			commonSplit();
			break;
		case 2:
			tokenizerSplit();
			break;
		case 3:
			patternSplit();
			break;
		case 4:
			substringSplit();
			break;
		default:
			break;
		}
		long end = System.nanoTime();
		System.out.println("Test "+num+": " + (end - start));
	}
	//java自带的split
	public void jdkSplit() {
		str.split(sign);
	}
	//common工具包下
	public void commonSplit(){
		StringUtils.split(str,"\\.");
	}
	//tokenizer
	public void tokenizerSplit(){
		new StringTokenizer(str,".");
	}
	//pattern
	public void patternSplit(){
		Pattern pattern = Pattern.compile("");
		pattern.split(str);
	}
	//substring
	public void substringSplit(){
		int k=0,count=0;
		  for (int i = 0; i < str.length(); i++) {
		   if(str.substring(i, i+1).equals(".")){
		    if(count==0){
		     System.out.print(str.substring(0, i)+"  ");
		    }else if(count==1){
		     System.out.print(str.substring(k+1, i)+"  ");
		    }else{
		     System.out.print(str.substring(k+1, i)+"  ");
		     System.out.print(str.substring(i+1, str.length())+"  ");
		    }
		    k=i;count++;
		   }
		  }
		  System.out.println();
	}
	public static void main(String[] args) {
		StringSplit split = new StringSplit();
		for (int i = 0; i < 5; i++) {
			split.split(i);
		}
	}
}