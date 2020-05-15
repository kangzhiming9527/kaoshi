package com.bj.util;

import com.bj.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kzm
 * @Date: 2020/5/14 19:34
 * @Description:
 */

public class TreeUtil {
    public static List<TreeNode> listGetStree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            //找到根
            if (tree.getPid().equals("-1")) {
                treeList.add(tree);
            }
            //找到子
            for (TreeNode treeNode : list) {
                if (treeNode.getPid().equals(tree.getValue()) ) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<TreeNode>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

    /**
     * 方法二、
     * @param list
     * @return
     */
    public static List<TreeNode> listToTree(List<TreeNode> list) {
        //用递归找子。
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            if (tree.getPid().equals("-1")) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static TreeNode findChildren(TreeNode tree, List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node.getPid().equals(tree.getValue()) ) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<TreeNode>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     *方法三
     * @param list
     * @return
     */
    private static List<TreeNode> toTree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            if(tree.getPid().equals("-1")){
                treeList.add(tree);
            }
        }
        for (TreeNode tree : list) {
            toTreeChildren(treeList,tree);
        }
        return treeList;
    }

    private static void toTreeChildren(List<TreeNode> treeList, TreeNode tree) {
        for (TreeNode node : treeList) {
            if(tree.getPid().equals(node.getValue()) ){
                if(node.getChildren() == null){
                    node.setChildren(new ArrayList<TreeNode>());
                }
                node.getChildren().add(tree);
            }
            if(node.getChildren() != null){
                toTreeChildren(node.getChildren(),tree);
            }
        }
    }
}
