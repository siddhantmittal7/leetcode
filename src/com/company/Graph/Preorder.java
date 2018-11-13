package com.company.Graph;

import java.util.ArrayList;
import java.util.List;

public class Preorder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode node){

        List<Integer> l1 = new ArrayList<Integer>();

        if(node == null)
            return l1;

        if(node.left == null && node.right == null){
            l1.add(node.val);
        }else if(node.left == null){
            l1.add(node.val);
            l1.addAll(preorderTraversal(node.right));
        }else if(node.right == null){
            l1.add(node.val);
            l1.addAll(preorderTraversal(node.left));
        }else{
            l1.add(node.val);
            l1.addAll(preorderTraversal(node.left));
            l1.addAll(preorderTraversal(node.right));
        }

        return l1;
    }
}
