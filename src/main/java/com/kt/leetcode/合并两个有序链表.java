package com.kt.leetcode;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        // 1、2、4
        // 1、3、4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode x = mergeTwoLists(list1, list2);
        while (x != null) {
            System.out.print(x.val);
            System.out.print(" -> ");
            x = x.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = list2;
        while (listNode != null) {
            merge(listNode, list1);
            listNode = listNode.next;
        }
        return list1;
    }

    /**
     * 编列list2
     * 每个元素和node比对，大于等于node就把设置成node.next
     * node = 1、list2 = 1、3、4
     * 1、2、4 - 1、3、4
     */
    private static void merge(ListNode source, ListNode target) {
        ListNode node = target;
        ListNode tempNode = target;
        while (tempNode != null) {
            if (source.val >= node.val) {
                // 原本的next
                ListNode oldNext = node.next;
                // 把node的next设置成source
                ListNode newNext = new ListNode(source.val);
                newNext.next = oldNext;
                node.next = newNext;
            }
            tempNode = tempNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
