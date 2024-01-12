package com.zeburan.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

public class Traverse {
    private  List<Integer> result = new ArrayList<>();

    //中序遍历：root-left-right
    public  List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left  = new TreeNode(7);
        root.left.right  = new TreeNode(9);

        List result = new Traverse().inorderTraversal(root);
        result.stream().forEach(System.out::println);
    }
}


