package com.company.Graph;

import java.util.HashMap;
import java.util.Stack;

public class MinimumDept {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int findBottomLeftValue(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        HashMap<TreeNode,Integer> hashMap = new HashMap<TreeNode,Integer>();

        int height = 0;
        int min_height = Integer.MIN_VALUE;


        while(true){
            if(root.left == null && root.right == null){

                if(height < min_height){
                    min_height = height;
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

        return min_height;

    }
}
