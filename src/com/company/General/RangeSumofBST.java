package com.company.General;

import java.util.ArrayList;
import java.util.List;

public class RangeSumofBST {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public static List<Integer> getInorderTraversal(TreeNode node){

          List<Integer> l1 = new ArrayList<Integer>();

          if(node.left == null && node.right == null){
              l1.add(node.val);
          }else if(node.left == null){
              l1.add(node.val);
              l1.addAll(getInorderTraversal(node.right));
          }else{
              l1.addAll(getInorderTraversal(node.left));
              l1.add(node.val);
              l1.addAll(getInorderTraversal(node.right));
          }

          return l1;
      }

      public static int rangeSumBST(TreeNode root, int L, int R) {

          List<Integer> l1 = getInorderTraversal(root);

          int sum =0;
          for(int i=0;i<l1.size();i++){
              if(l1.get(i) >=L || l1.get(i) <= R){
                  sum = sum + l1.get(i);
              }
          }

          return sum;
      }

      public static void main(String[] args){

      }
}
