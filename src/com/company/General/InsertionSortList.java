package com.company.General;

import java.util.Arrays;

public class InsertionSortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ListNode sortList(ListNode head) {

        int size = 0;

        ListNode returnHead = head;

        if(head == null){
            return null;
        }


        while(head != null){
            size++;
            head = head.next;
        }

        int[] array = new int[size];

        int i=0;

        head = returnHead;
        while(head != null){
            array[i] = head.val;
            head = head.next;
            i++;
        }

        Arrays.sort(array);

        ListNode newhead = null;


        for(i=0;i<array.length;i++){
            ListNode l1 = new ListNode(array[i]);

            if(newhead != null){
                newhead.next = l1;
            }else{
                returnHead = l1;
            }

            newhead = l1;
        }

        return returnHead;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode n = sortList(node1);
    }
}
