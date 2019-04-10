package com.coder.leetcode;


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class LinkSum {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            
            ListNode l3 = null;
            
            boolean oneIn = false;
            
            ListNode l1TempNode = l1;
            ListNode l2TempNode = l2;
            ListNode l3TempNode = null;
            
            while(l1TempNode!=null||l2TempNode!=null||oneIn){
                
                int l1TempNum = 0 ;
                int l2TempNum = 0 ;
                
                if(l1TempNode!=null){
                    l1TempNum = l1TempNode.val;
                    l1TempNode = l1TempNode.next;
                }
                if(l2TempNode!=null){
                    l2TempNum = l2TempNode.val;
                    l1TempNode = l1TempNode.next;
                }
                
                int sum = l1TempNum + l2TempNum;
                
                if(oneIn){
                    sum++;
                    oneIn = false;
                }
                
                if(sum>10){
                    oneIn = true;
                    sum = sum -10;
                }
                
                ListNode temp = new ListNode(sum);
                
//                 ListNode l3Temp = null;
                
//                 for(int j = 0;j<i;j++){
//                     l3Temp = temp
//                 }
                
                if(l3==null){
                    l3 = temp;
                }else{
                    
                    if(l3TempNode==null){
                        l3.next = temp;
                        l3TempNode = l3.next;
                        
                    }else{
                        l3TempNode.next = temp;
                        l3TempNode =null;
                        l3TempNode = temp;
                    }
                }
            }
            
            return l3;
        }
}
