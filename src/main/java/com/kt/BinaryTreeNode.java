package com.kt;

public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * 前序遍历
     * 从root开始遍历左子树，再前序遍历右子树
     *
     */
    public void preOrder() {
        preOrder(this);
    }

    private void preOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
