package com.brianway.learning.java.base.suanfa;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author lengbing
 * @version 1.0
 * @date 2020/4/21 下午3:13
 * @since 1.8
 */
public class Solution {


    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree, list);
        return Convert(list);

    }
    //中序遍历，在list中按遍历顺序保存
    public static void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left != null){
            Convert(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if(pRootOfTree.right != null){
            Convert(pRootOfTree.right, list);
        }
    }
    //遍历list，修改指针
    public static TreeNode Convert(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(13);
        Convert(node);
    }
}
