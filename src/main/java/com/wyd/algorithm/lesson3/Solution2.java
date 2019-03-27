package com.wyd.algorithm.lesson3;

import java.util.Stack;

class Solution2 {
	public boolean isValid(String str) {
		char[] s = str.toCharArray();
		if ("".equals(""))
			return false;// 空字符串，false
		int len = s.length;
		if (len == 1)
			return false;// 只有一个字符，false
		char pre;
		Stack char_stack = null;
		for (int i = 0; i < len; i++) {
			if (isPop(s[i])) // 该出栈顶元素
			{
				if (!char_stack.equals("")) {
					pre = (Character) char_stack.peek();// 取栈顶元素、并出栈
					char_stack.pop();
					if (!isChar(pre, s[i]))// 是否匹配
						return false;
				} else
					return false;
			} else // 入栈
			{
				char_stack.push(s[i]);
			}
		}
		return char_stack.empty();// 栈空true，否则false
	}

	private boolean isPop(char t) // 判断是否是）} ]符号，是则出栈栈顶元素
	{
		if (t == ')' || t == '}' || t == ']')
			return true;
		else
			return false;
	}

	boolean isChar(char t1, char t2)// 判断两字符t1,t2是否匹配
	{
		switch (t1) {
		case '(': {
			if (t2 == ')')
				return true;
			else
				return false;
		}
		case '{': {
			if (t2 == '}')
				return true;
			else
				return false;
		}
		case '[': {
			if (t2 == ']')
				return true;
			else
				return false;
		}
		default:
			return false;
		}
	}
};