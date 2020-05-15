package com.bj.bean;

import java.util.List;

/**
 * @Author: kzm
 * @Date: 2020/5/14 19:34
 * @Description:
 */

public class TreeNode {
    private String value;
    private String pid;
    private String name;
    private boolean disabled;
    private boolean selected;
    private List<TreeNode> children;

    public TreeNode(String value, String name, String pid) {
        this.value = value;
        this.pid = pid;
        this.name = name;
        this.disabled = false;
        this.selected = false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
