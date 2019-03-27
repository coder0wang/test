package com.coder.kkb.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * 此类描述的是：  
 * 贪心算法简单实现：田忌赛马
 * @author: Coder_Wang 
 * @version: 2019年1月28日 下午1:31:08
 */
public class Greedy {
	public static void main(String args[]) {
		int num = 3;
		//田忌的马
		List<Integer> list1 = new ArrayList<>(num);
		//插入值为速度
		list1.add(1);
		list1.add(3);
		list1.add(5);
		//齐威王的马
		List<Integer> list2 = new ArrayList<>(num);
		list2.add(2);
		list2.add(4);
		list2.add(6);
		while (true) {
			
			if (num == 0)
				break;
			// 处理数据
			Collections.sort(list1);
			Collections.sort(list2);
			int i = 0, j = 0, x = num - 1, y = num - 1, count = 0;
			boolean bLast = true;
			while (bLast) {
				// 是否是最后一匹马
				if (x == i || num<=0 ){
					bLast = false;
				}
				// 如果田忌当前最好的马可以胜齐王最好的马，那么比一场
				if (list1.get(x) > list2.get(y)) {
					num--;
					x--;
					y--;
					count += 200;
				// 如果田忌当前最差的马可以胜齐王最差的马，那么比一场
				} else if (list1.get(i) > list2.get(j)) {
					num--;
					i++;
					j++;
					count += 200;
				// 否则，让田忌最差的马和齐王最好的好比一场
				} else {
					if (list1.get(i) < list2.get(y)){
						count -= 200;
					}
					i++;
					y--;
					num--;
				}
			}
			System.out.println(count);
			list1.clear();
			list2.clear();
		}

	}
}