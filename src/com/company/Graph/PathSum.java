package com.company.Graph;

import java.util.HashMap;
import java.util.Stack;

public class PathSum {

    public static class TreeNode {
      int val;
      TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        public static boolean hasPathSum(TreeNode root, int sum) {

            if(root == null)
                return false;

            HashMap<TreeNode,Integer> pathsumMap = new HashMap<TreeNode,Integer>();

            int pathsum = 0;

            Stack<TreeNode> stack = new Stack<TreeNode>();

            pathsum = pathsum + root.val;

            while(true){
                if(root.left == null && root.right == null){

                    if(pathsum == sum)
                        return true;
                    if(stack.isEmpty()){
                        break;
                    }
                    root = stack.pop();
                    pathsum = pathsumMap.get(root);
                    pathsum = pathsum + root.val;
                }

                if(root.left != null){
                    if(root.right != null){
                        stack.push(root.right);
                        pathsumMap.put(root.right,pathsum);
                    }
                    root = root.left;
                    pathsum = pathsum + root.val;
                }else{
                    if(root.right != null){
                        root = root.right;
                        pathsum = pathsum + root.val;
                    }
                }
            }

           return false;

        }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-2);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;

        System.out.print(hasPathSum(node,-4));

    }
}
