package com.coder.test;

public class Test {

    public static void main(String[] args) {
        
        int lengthNum = 3;
        
        for(int i=1;i<=lengthNum;i++){
            //打印空格
            for(int j=i;j<lengthNum;j++){
                System.out.print(" ");
            }
            //打印三角形
            for(int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}
