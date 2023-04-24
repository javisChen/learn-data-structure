package com.kt;


/**
 * 线性表单链表实现
 *
 * @param <T>
 */
public class LinkedList<T> implements Collection<T> {

    /**
     * 头节点
     */
    private Node<T> head;

    /**
     * 尾结点
     */
    private Node<T> tail;

    /**
     * 链表长度
     */
    private int size;

    /**
     * 思路：
     * 判断下标是否合法
     * 找到对应的位置并返回
     */
    @Override
    public T getElement(int index) {
        if (size == 0) {
            return null;
        }
        Node<T> node = head;
        int c = 0;
        while (node != null) {
            if (c == index) {
                return node.data;
            }
            node = node.next;
            c++;
        }
        return null;
    }

    /**
     * 插入元素
     * 思路：
     * 1.判断链表长度是否为0，0的话初始化头尾结点
     * 2.长度大于>0的话，创建新结点设置为尾结点，并且把原来的尾结点的后继结点设置成新的尾结点
     */
    @Override
    public boolean addElement(T element) {
        Node<T> node = new Node<>(element, null, null);
        if (size == 0) {
            tail = node;
            head = node;
            head.next = tail;
            tail.pre = head;
        } else {
            node.pre = tail;
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    /**
     * 插入元素到指定下标
     * 思路：
     * 先判断下标位置是否合法
     * 如果下标等于链表长度，直接插入尾结点后
     * 否则的话一直找到对应下标的位置
     */
    @Override
    public boolean addElement(T element, int index) {
        return true;
    }

    /**
     * 思路：
     * 如果数据匹配上了
     * 把上一节点的next设置为新节点
     * 新结点next设置成前驱节点的旧next
     */
    @Override
    public boolean removeElement(T element) {
        if (size == 0) {
            return false;
        }
        if (head.data.equals(element)) {
            head = head.next;
            return true;
        }
        Node<T> node = head.next;
        while (node != null) {
            if (node.data.equals(element)) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                return true;
            }
            node = node.next;
        }
        return true;
    }

    @Override
    public Object[] getElements() {
        return null;
    }

    public void print() {
        if (size == 0) {
            return;
        }
        Node<T> node = head;
        while (true) {
            System.out.print(node.data);
            node = node.next;
            if (node == null) {
                break;
            }
            System.out.print(" -> ");
        }
        System.out.println();
    }


    /**
     * 节点
     *
     * @param <T>
     */
    public static class Node<T> {
        /**
         * 数据域
         */
        private T data;

        /**
         * 后继节点
         */
        private Node<T> next;

        /**
         * 后继节点
         */
        private Node<T> pre;

        public Node(T data, Node<T> next, Node<T> pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }

    }

    public static void main(String[] args) {
//        java.util.LinkedList<Integer> integers = new java.util.LinkedList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(1);
//        integers.remove(Integer.valueOf(1));
//        for (Integer integer : integers) {
//            System.out.print(integer);
//        }
        System.out.println();
        System.out.println("==========");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addElement(1);
        linkedList.addElement(2);
        linkedList.addElement(4);
        linkedList.addElement(5);
        linkedList.addElement(8);
        // 打印初始化链表
        linkedList.print();

        // 获取某个下标的元素
        System.out.println(linkedList.getElement(2));

        // 删除某个元素
        linkedList.removeElement(8);
        linkedList.print();
    }
}
