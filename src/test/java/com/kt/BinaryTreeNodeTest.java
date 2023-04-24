package com.kt;

import org.junit.Test;

public class BinaryTreeNodeTest {

    @Test
    public void getElements() {

        BinaryTreeNode<String> root = createNode("A");
        BinaryTreeNode<String> B = createNode("B");
        BinaryTreeNode<String> D = createNode("D");
        D.setLeft(createNode("G"));
        D.setRight(createNode("H"));
        B.setLeft(D);
        BinaryTreeNode<String> C = createNode("C");
        root.setLeft(B);
        root.setRight(C);
//        root.getElements();
    }

    private BinaryTreeNode<String> createNode(String g) {
        return new BinaryTreeNode<>(g);
    }
}