package com.company.Graph;

import java.util.Arrays;
import java.util.TreeSet;

public class ConvertSortedArrayToBST {

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public static TreeNode sortedArrayToBST(int[] nums) {

         if(nums.length == 0){
             return null;
         }else if(nums.length == 1){
             TreeNode node = new TreeNode(nums[0]);
             node.left = null;
             node.right = null;
             return node;
         }else if(nums.length == 2){
              TreeNode node = new TreeNode(nums[1]);
              TreeNode node2 = new TreeNode(nums[0]);
              node.left = node2;
              node.right = null;
              return node;
          }else if(nums.length == 3){
              TreeNode node = new TreeNode(nums[1]);
              TreeNode node2 = new TreeNode(nums[0]);
              TreeNode node3 = new TreeNode(nums[2]);
              node.left = node2;
              node.right = node3;
              return node;
          }else{
             int length = nums.length;
             int root = 0;
             if(length%2 != 0){
                 root = length/2 + 1;
             }else{
                 root = length/2;
             }
             TreeNode node = new TreeNode(nums[root-1]);

             int[] leftNode = Arrays.copyOfRange(nums,  0, root-1);
             int[] rightNode = Arrays.copyOfRange(nums,  root, length);

             node.left = sortedArrayToBST(leftNode);
             node.right = sortedArrayToBST(rightNode);
             return node;
         }
     }

     public static void main(String[] args){
         int[] nums = {0};
         TreeNode node = sortedArrayToBST(nums);
         System.out.println(node.val);
     }
}
