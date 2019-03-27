package com.coder.test.dic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类描述的是：
 * 
 * @author: Coder_Wang
 */
public class DicSerialize {
	public static void main(String[] args) {
		List<Map<String, String>> baseList = new ArrayList<Map<String, String>>();

		Map<String, String> map0 = new HashMap<String, String>();
		/**
		 * 原始文本中应该是 \n  但是\n 放入 map 就变成了回车. 
		 * 没有试其他方式存储,就先用双斜杠代替,或者输入前就直接转义
		 */
		
		map0.put("0\\nk1=", "v1=\\n");
		map0.put("0\\nk2=", "v2=\\t\"");

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1k1=", "v1=\\n");
		map1.put("1k2=", "v2=\\t\"");

		baseList.add(map0);
		baseList.add(map1);
		
		System.out.println(store(baseList));
	}

	/**
	 * 存储到string
	 */
	public static String store(List<Map<String, String>> baseList) {

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < baseList.size(); i++) {
			Map<String, String> tempMap = baseList.get(i);
			for (String key :tempMap.keySet()) {
				String value = tempMap.get(key);
				key = replaceSpecialStr(key);
				value = replaceSpecialStr(value);
				sb.append(key+"="+value+";");
			}
			sb.append("\\n");
		}
		return sb.toString();
	}

	/**
	 * string转对象
	 */
	public static List<Map<String, String>> load(String text) {
		List<Map<String, String>> baseList = new ArrayList<Map<String, String>>();
		//split!!! TODO
		String[] strs = text.split(";\n");
		for (int i = 0; i < strs.length; i++) {
			//判断 = 号前边没有 \ 的为分隔符;分隔切分出 字符 再通过判断 = 前边没有斜杠的 key和value
			
		}
		return baseList;
	}

	/**
	 * 特殊字符处理
	 */
	static String[] specialStrs = {"\\n","\\t","=",",",";"};
	
	public static String replaceSpecialStr(String str) {
		
		for (int i = 0; i < specialStrs.length; i++) {
//			System.out.println("before str :" + str);
			str = replaceAllStr(str, specialStrs[i],"\\"+ specialStrs[i] ,0);
//			System.out.println("after str :" + str);
		}

		return str;
	}

	/**
	 * 替换字符串
	 */
	public static String replaceAllStr(String fullSrc, String target, String replacement,int startNum) {

		if (fullSrc == null || target == null || replacement == null) {
			return fullSrc;
		}
		String src = "";
		char[] fullA = null;
		if(startNum!=0){
//			System.out.println(fullSrc);
			char[] full = fullSrc.toCharArray();
			char[] srcChar = new char[full.length-startNum];
			fullA = new char[startNum];
//			System.out.println(full.length+"  "+ srcChar.length +"  "+ startNum);
			int j = 0;
			for (int i = 0; i < full.length; i++) {
				if(i>=startNum){
					srcChar[j] = full[i];
					j++;
				}else{
					fullA[i]=full[i];
				}
			}
			src = new String(srcChar);
//			System.out.println(src);
		}else{
			src = fullSrc;
		}
		int idx = src.indexOf(target);
		if (idx == -1){
			return fullSrc;
		}
		int pst = 0;
		char[] cs = src.toCharArray();
		char[] rs = new char[src.length() - target.length() + replacement.length()];
		for (int i = 0; i < cs.length; i++) {
			if (i == idx) {
				for (char c : replacement.toCharArray()) {
					rs[pst] = c;
					pst++;
				}
				continue;
			}
			if (i > idx && i < idx + target.length())
				continue;
			rs[pst] = cs[i];
			pst++;
		}
		String returnStr = new String(rs);
		if(fullA!=null){
			returnStr = new String(fullA)+returnStr;
		}
		return replaceAllStr(returnStr, target, replacement,idx+target.length()+1);
	}
}
