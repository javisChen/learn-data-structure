package com.kt;

import java.util.NoSuchElementException;

/**
 * 线性表单链表实现
 *
 * @param <T>
 */
public class LinkedList<T> implements Collection<T> {

    /**
     * 头节点
     */
    private Node<T> first;

    /**
     * 尾结点
     */
    private Node<T> last;

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
        if (index > size) {
            throw new NoSuchElementException();
        }
        Node<T> node = first;
        int i = 0;
        while (i < size) {
            if (i == index) {
                return node.data;
            }
            if (node.next == null) {
                return null;
            }
            node = node.next;
            i++;
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
        Node<T> last = this.last;
        Node<T> newNode = new Node<>(element, null);
        this.last = newNode;
        if (size == 0) {
            this.first = newNode;
        } else {
            last.next = this.last;
        }
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
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index == size) {
            addElement(element);
            return true;
        }
        Node<T> prev = this.first;
        int i = 0;
        while (i < index - 1) {
            prev = prev.next;
            i++;
        }
        prev.next = new Node<>(element, prev.next);
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
            throw new NoSuchElementException();
        }
        if (this.first.data.equals(element)) {
            this.first = first.next;
            size--;
        } else {
            Node<T> curr = first;
            while (curr.next != null) {
                if (curr.next.data.equals(element)) {
                    curr.next = curr.next.next;
                    size--;
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public Object[] getElements() {
        Object[] result = new Object[size];
        int i = 0;
        Node<T> x = first;
        while (x != null) {
            result[i++] = x.data;
            x = x.next;
        }
        return result;
    }


    /**
     * 节点
     *
     * @param <T>
     */
    public class Node<T> {
        /**
         * 数据域
         */
        private T data;

        /**
         * 后继节点
         */
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
