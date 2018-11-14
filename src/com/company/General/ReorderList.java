package com.company.General;

import java.util.HashMap;
import java.util.List;

public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static void reorderList(ListNode head) {


        HashMap<Integer,ListNode> detect = new HashMap<Integer,ListNode>();

        int size = 0;

        if(head == null){
            return;
        }

        //size++;

        int i =0;

        while(head != null){
            detect.put(i,head);
            size++;
            head = head.next;
            i++;
        }

        int modvalue = 0;
        if(size%2 == 0){
            modvalue = size/2;
        }else{
            modvalue = size/2 + 1;
        }

        for(int j=0;j<modvalue-1;j++){

            ListNode ith = detect.get(j);
            ListNode match = detect.get(size-j-1);

            if(ith != match){

                ListNode tem= ith.next;

                ith.next = match;
                match.next = tem;
            }
        }
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);
    }
}
