package com.company.Graph;

import java.util.HashMap;
import java.util.Stack;

public class FindBottomLeftTreeValue {

     public static class TreeNode {
         int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

        public static int findBottomLeftValue(TreeNode root) {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            HashMap<TreeNode,Integer> hashMap = new HashMap<TreeNode,Integer>();

            int leftmost = 0;
            int height = 0;
            int max_height = Integer.MIN_VALUE;


            while(true){
                if(root.left == null && root.right == null){

                    if(height > max_height){
                        max_height = height;
                        leftmost = root.val;
                    }
                    if(stack.isEmpty())
                        break;
                    root = stack.pop();
                    height = hashMap.get(root);
                }

                if(root.left != null){
                    if(root.right != null){
                        stack.push(root.right);
                        hashMap.put(root.right,height+1);
                    }
                    root = root.left;
                    height = height + 1;
                }else{
                    if(root.right != null){
                        root = root.right;
                        height = height + 1;
                    }
                }



            }

            return leftmost;

        }


    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(62);
        TreeNode node6 = new TreeNode(31);

        node.left = node1;
        node.right = node2;

        node2.left = node3;
        node2.right = node4;

        node3.left = node6;
        node4.right = node5;



        System.out.print(findBottomLeftValue(node));

    }
}
