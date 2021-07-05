package com.kt;

import java.util.StringJoiner;

public class SequenceStorageStructure<T> {

    private Object[] elements = new Object[10];
    private int size = 0;

    public T getElement(int i) {
        if (i < 0 || i < elements.length - 1 || i > elements.length) {
            throw new RuntimeException("非法的下标位置");
        }
        return (T) elements[i];
    }

    public void addElement(T element) {
        if (size > elements.length - 1) {
            throw new RuntimeException(element +"插入失败，存储结构已满");
        }
        elements[size] = element;
        size++;
    }

    public void addElement(T element, int i) {
        if (size == elements.length - 1) {
            throw new RuntimeException("线性表已满");
        }
        if (i < 0 || i > elements.length - 1) {
            throw new RuntimeException("非法的下标位置");
        }
        if (i != elements.length - 1) {
            // 找到需要插入的下标元素，并且把该下标元素以及往后的元素都往后移动一位
            for (int j = elements.length - 1; j > i; j--) {
                elements[j] = elements[j - 1];
            }
        }
        elements[i] = element;
        size++;
    }

    public void removeElement(int i) {
        int length = elements.length - 1;
        if (size == length) {
            throw new RuntimeException("线性表已满");
        }
        if (i < 0 || i > length) {
            throw new RuntimeException("非法的下标位置");
        }
        elements[i] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public Object[] getElements() {
        return elements;
    }

    public static void main(String[] args) {
        SequenceStorageStructure<Integer> structure = new SequenceStorageStructure<>();
        structure.addElement(1);
        structure.addElement(2);
        structure.addElement(3);
        structure.addElement(4);
        structure.addElement(5);
        structure.addElement(8, 9);
        Object[] elements = structure.getElements();
        print(elements);
        structure.removeElement(2);
        System.out.println("============================");
        print(elements);
    }

    private static void print(Object[] elements) {
        StringJoiner joiner = new StringJoiner(" ");
        for (Object element : elements) {
            joiner.add(String.valueOf(element));
        }
        System.out.println(joiner);
    }
}
