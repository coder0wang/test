package com.coder.kkb.jvm;

public class TestStr {

    
    /**
     * 基本问题
     */
    public void str1(){
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        
    }
    
    
    /**
     * 问题升级
     */
    public static void str2(){
        String str1 = "ab";
        String str2 = "c";
        String str3 = "ab" + "c";
        String str4 = str1 + str2;
        String str5 = "ab" + str2;
        
        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str4 == str5);
        
        String str6 = "ab" +  new String("c");
        
        System.out.println(str3 == str6);
        System.out.println(str5 == str6);
        
        String str7 = "ab" +  new String("c");
        String str8 = str1 + str2;
        
        System.out.println(str7 == str6);
        System.out.println(str4 == str8);
        
    }
    
    
    /**
     * 类型问题
     */
    public static void str3(){
        String str1 = "a1";
        String str2 = "a"+1;
        System.out.println(str1==str2);
    }
    
    
    
    /**
     * final 问题
     * 类加载问题
     */
    public static void str4(){
        String str1 = "abc"; 
        final String str2 = "c"; 
        String str3 = "ab" + str2; 
        
        System.out.println(str1 == str3);
    }
    
    public static void main(String[] args) {
        str3();
    }
}
