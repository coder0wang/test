package com.coder.leetcode;

public class NoRepeatNumLength {

    public static void main(String[] args) {
        lengthOfLongestSubstring("");
    }

    public static int lengthOfLongestSubstring(String aa) {
        String s ="dvdf";
        char[] aChars = s.toCharArray();
        int maxNum = 0;
        int nowNum = 0;
        /**
         * 线型输出字符串，发现重复的重新计数
         */

        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < aChars.length; i++) {
            char nowChar = aChars[i];
            String nowStr = (String.valueOf(nowChar));
            if (tempStr != null&&tempStr.length()>0) {
                /**
                 * 循环查找在不在之前的 在就重新计算，不在就加入之前的串
                 */
                int signNum = tempStr.indexOf(nowStr);

                if (signNum != -1) {
                    /**
                     * 数组迁移
                     */
                    tempStr = new StringBuilder(tempStr.substring(signNum+1));
                    
                }
            }
            tempStr.append(nowStr);
            nowNum = tempStr.length();
            maxNum = maxNum > nowNum ? maxNum : nowNum;
        }
        System.out.println(maxNum);
        return maxNum;
    }

    public int lengthOfLongestSubstringT(String s) {
        if (s.equals(""))
            return 0;
        int length = s.length();
        if (length == 1)
            return 1;
        char[] a = s.toCharArray();
        int res = 0;
        int i = 0;
        int j = 1;
        while (j < length) {
            for (int x = i; x < j; x++) {
                if (a[x] == a[j]) {
                    if (j - i > res) {
                        res = j - i;
                    }
                    i = x + 1;
                    break;
                }
            }
            if (j == length - 1) {
                if (j - i + 1 > res) {
                    res = j - i + 1;
                }
            }
            j++;
        }
        return res;
    }
}
