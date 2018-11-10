package com.company.Graph;

public class FlattenBinaryTreetoLinkedList {

      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

     public TreeNode helper(TreeNode root){
         if(root.left == null && root.right == null){
             return root;
         }else if(root.left == null){
             root.right = helper(root.right);
             return root;
         }else if(root.right == null){
             root.left = helper(root.left);
             return root;
         }else{
             root.left = helper(root.left);
             root.right = helper(root.right);
             return root;
         }
     }

     public void flatten(TreeNode root) {

          TreeNode node = helper(root);


      }
}
