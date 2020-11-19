package com.coder.leetcode;

/**
 Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean over = false;
        while(l1.next!=null||l2.next!=null){
            
            int a = 0;
            if(l1.next!=null){
                a = l1.val;
            }
            int b = 0;
            if(l2.next!=null){
                b = l2.val;
            }
        }
        
        return null;
    }
}
 class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }