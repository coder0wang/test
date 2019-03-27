package com.wyd.algorithm.lesson3;

import java.util.Stack;

class Solution {
public
    int longestValidParentheses(String ss) {
	char[] str = ss.toCharArray();
        int maxLen = 0;
        int count = 0;
        Stack s = null;
        int firstLeft = 0;
        
        for(int i = 0; i < str.length; i++){
            //i代表当前的下标
            if(str[i] == '('){
                s.push(i); // 遇到（ 就push
            }
            else{
                //str[i] == ')'
                if(!s.empty()){
                    //栈非空
                    s.pop();
                    if(!s.empty()){
                        //pop后栈里还有元素，比如"()(()()"来举例
                        int lastIndex = (Integer) s.peek(); //lastIndex 是中间那个（ 的下标，即为2
                        int len = i - lastIndex; // 此时 i = 4或者 6，以6举例的话， len等于4
                        if(len > maxLen)         // if ( 4 > 2)  true     maxLen = 4
                            maxLen = len;
                    }
                    else{
                        //pop后没有元素了，比如"(())"情况举例
                        int len = i - firstLeft + 1; //此时firstLeft等于0，i 等于3的话，len等于 3 - 0 + 1 = 4
                        if(len > maxLen){
                            maxLen = len;
                        }
                    }
                }
                else{
                    firstLeft = i + 1; //栈为空的时候遇到），将firstLeft移到i 的下一个。
                }
            }
        }
        return maxLen;
    }
};