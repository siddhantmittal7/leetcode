package com.company.Graph;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {


    public List<Integer> postorderTraversal(Preorder.TreeNode node){

        List<Integer> l1 = new ArrayList<Integer>();

        if(node == null)
            return l1;

        if(node.left == null && node.right == null){
            l1.add(node.val);
        }else if(node.left == null){
            l1.addAll(postorderTraversal(node.right));
            l1.add(node.val);
        }else if(node.right == null){
            l1.addAll(postorderTraversal(node.left));
            l1.add(node.val);
        }else{
            l1.addAll(postorderTraversal(node.right));
            l1.addAll(postorderTraversal(node.left));
            l1.add(node.val);

        }

        return l1;
    }
}
