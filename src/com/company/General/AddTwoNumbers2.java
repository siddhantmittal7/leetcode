package com.company.General;

import java.util.Stack;

public class AddTwoNumbers2 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

          if(l1 == null || l2 == null){
              return null;
          }


            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();

            s1.add(l1.val);

              while(l1.next != null){
                  l1 = l1.next;
                  s1.add(l1.val);
              }


            s2.add(l2.val);

                while(l2.next != null){
                    l2 = l2.next;
                    s2.add(l2.val);
                }

                int carry = 0;

            int num1 = 0;
            if(s1.size() > 0){
                num1 = s1.pop();
            }
            int num2 = 0;
            if(s2.size() > 0){
                num2 = s2.pop();
            }

            int numfinal = num1 + num2 + carry;

            int rem = numfinal%10;
            carry = numfinal/10;

            ListNode listtillnow = new ListNode(rem);

            while(true){

                if(s1.size() == 0 && s2.size() == 0)
                    break;

                num1 = 0;
                if(s1.size() > 0){
                    num1 = s1.pop();
                }
                num2 = 0;
                if(s2.size() > 0){
                    num2 = s2.pop();
                }

                numfinal = num1 + num2 + carry;

                rem = numfinal%10;
                carry = numfinal/10;
                ListNode listNode = new ListNode(rem);
                listNode.next = listtillnow;
                listtillnow = listNode;

            }

            if(carry > 0){
                ListNode listNode = new ListNode(carry);
                listNode.next = listtillnow;
                listtillnow = listNode;
            }


            return listtillnow;

        }

        public static void main(String[] args){

          ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(3);

            l1.next = l2;


          ListNode l3 = addTwoNumbers(l1,l1);

        }
}
