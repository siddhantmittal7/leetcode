package com.company.General;

import java.util.HashMap;

public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }

    public static ListNode detectCycle(ListNode head) {

        HashMap<ListNode,Boolean> detect = new HashMap<ListNode,Boolean>();

        if(head == null)
            return null;

        while(head.next != null){
            detect.put(head,true);
            ListNode newNode = head.next;

            if(newNode.next != null && detect.get(newNode.next) != null && detect.get(newNode.next)){
                return newNode.next;
            }

            head = newNode;
        }

        return null;
    }

    public static void main(String[] args){

    }
}
