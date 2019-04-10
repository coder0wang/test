package com.coder.leetcode;

public class Test {

    
    public static void testFor(){

        
        for1:
        for (int i = 0; i < 10; i++) {
           
            System.out.println(i);
            for2:
            for (int j = 10; j < 20; j++) {
                System.out.println(j);
                if(j==11){
                    break for2;
                }
            }
            System.out.println("~~~"+i);
        }
        
    
    }
    
    public static void main(String[] args) {
        
        
        
        char[] tmepChars = new char[10];
        char[] tmepChars1 = null;
        
        
        System.out.println(tmepChars==null);
        System.out.println(tmepChars[0]==0);
        System.out.println(tmepChars1==null);
        
    }
}
