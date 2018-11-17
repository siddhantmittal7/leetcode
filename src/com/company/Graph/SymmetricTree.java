package com.company.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> preOrde(TreeNode node){

        List<Integer> l1 = new ArrayList<Integer>();

        if(node == null)
            return l1;

        if(node.left == null && node.right == null){
            l1.add(node.val);
        }else if(node.left == null){
            l1.add(node.val);
            l1.addAll(preOrde(node.right));
        }else if(node.right == null){
            l1.add(node.val);
            l1.addAll(preOrde(node.left));
        }else{
            l1.add(node.val);
            l1.addAll(preOrde(node.left));
            l1.addAll(preOrde(node.right));
        }

        return l1;
    }

    public static List<Integer> postOrder(TreeNode node){

        List<Integer> l1 = new ArrayList<Integer>();

        if(node == null)
            return l1;

        if(node.left == null && node.right == null){
            l1.add(node.val);
        }else if(node.left == null){
            l1.addAll(postOrder(node.right));
            l1.add(node.val);
        }else if(node.right == null){
            l1.addAll(postOrder(node.left));
            l1.add(node.val);
        }else{
            l1.addAll(postOrder(node.left));
            l1.addAll(postOrder(node.right));
            l1.add(node.val);
        }

        return l1;
    }

    public static boolean isSymmetric(TreeNode root) {

        if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null){
            return false;
        }else if(root.right == null){
            return false;
        }else{
            List<Integer> ll = preOrde(root.left);
            List<Integer> lr = postOrder(root.right);

            if(ll.size() != lr.size()){
                return false;
            }else{
                for(int i=0;i<ll.size();i++){
                    if(ll.get(i) != lr.get(lr.size()-i-1)){
                        return false;
                    }
                }
                return true;
            }
        }

    }


    public static void main(String[] args){
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);

        node.left = node1;
        node.right = node2;

        System.out.println(isSymmetric(node));

    }
}
