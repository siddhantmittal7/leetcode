package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeHelper(ListNode l1, ListNode l2){
        ListNode new_l = new ListNode(0);

        ListNode return_l = new_l;


        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                new_l.next = l2;
                break;
            }else if(l1 != null && l2 == null){
                new_l.next = l1;
                break;
            }else{
                if(l1.val > l2.val){
                    ListNode n = new ListNode(l2.val);
                    new_l.next = n;
                    new_l = new_l.next;
                    l2 = l2.next;
                }else{
                    ListNode n = new ListNode(l1.val);
                    new_l.next = n;
                    new_l = new_l.next;
                    l1 = l1.next;
                }
            }
        }
        return return_l.next;

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listHelper = new ArrayList<ListNode>(Arrays.asList(lists));
        if (lists == null || listHelper.size() == 0){
            return null;
        }else if(listHelper.size() == 1){
            return listHelper.get(0);
        }
        else{
            ListNode l1 =listHelper.get(0);
            ListNode l2 =listHelper.get(1);
            ListNode l = mergeHelper(l1,l2);
            listHelper.remove(l1);
            listHelper.remove(l2);
            listHelper.add(l);
            lists = listHelper.toArray(new ListNode[0]);
            return mergeKLists(lists);
        }

    }

    public static ListNode createNode(int[] a){
        ListNode new_l = new ListNode(0);

        ListNode return_l = new_l;

        for(int i:a){
            ListNode n = new ListNode(i);
            new_l.next = n;
            new_l = new_l.next;
        }

        return return_l.next;
    }

    public static void print_ll(ListNode n){

        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

    public static void main(String[] args){

        int[] a = {1,4,5};
        ListNode l1 = createNode(a);
        int[] b = {1,3,4};
        ListNode l2 = createNode(b);
        int[] c = {2,6};
        ListNode l3 = createNode(c);

        ListNode[] li = {};

        ListNode ans = mergeKLists(li);

        print_ll(ans);


    }
}
