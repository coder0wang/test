package com.wyd.jvm.lesson1;
import javax.swing.JOptionPane;

public class test01 {
 public static void main(String sgs[]) {
  int number =-6;
  System.out.println("该数的二进制数值为:");
  int sum;
  String result = "";
  for (int i = number; i >= 1; i /= 2) {
   if (i % 2 == 0) {
    sum = 0;
   } else {
    sum = 1;
   }
   System.out.println(result);
   result = sum + result;
  }
  System.out.print(result);
 }
}