package com.kt;

import java.util.Arrays;

/**
 * 顺序列表简单实现
 *
 * @param <T>
 */
public class ArrayList<T> implements Collection<T> {

    // 默认容量10
    private static final int DEFAULT_CAPACITY = 10;

    // 存储数据数组
    private Object[] elements;

    // 线性表长度
    private int size;

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取元素
     * 算法思路：
     * 1.校验下标是否合法（不能小于0或大于列表长度）
     * 2.直接返回下标对应的元素
     */
    @Override
    public T getElement(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("非法的下标位置");
        }
        return (T) elements[index];
    }

    /**
     * 添加元素
     * 算法思路：
     * 1.校验元素数组是否还有空间
     * 2.在数组末尾插入元素
     * 3.size + 1
     */
    @Override
    public boolean addElement(T element) {
        if (size == elements.length - 1) {
            throw new RuntimeException("空间已满");
        }
        elements[size++] = element;
        return true;
    }

    /**
     * 指定位置插入元素
     * 算法思路：
     * 1.校验元素数组是否还有空间、下标位置是否合法（下标不能小于0或者大于表长度）
     * 2.如果下标位置不在最后一位的话，从最后一位开始遍历到第i个位置，把元素都向后移动一位
     * 3.把指定下标设置为目标值
     */
    @Override
    public boolean addElement(T element, int index) {
        if (size == elements.length - 1) {
            throw new RuntimeException("空间已满");
        }
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("非法的下标位置");
        }
        if (index != size - 1 && size - 1 - index >= 0) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = element;
        size++;
        return true;
    }

    /**
     * 删除元素
     * 算法思路：
     * 1.找到第一个匹配的元素
     * 2.如果不是最后一个元素的话，从第i个开始遍历，把元素往前移动一位
     * 3.把指定下标设置为目标值
     * @return 删除
     */
    @Override
    public boolean removeElement(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void remove(int i) {
        if (i != size - 1 && size - 1 - i >= 0) {
            System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
        }
        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    @Override
    public Object[] getElements() {
        return Arrays.copyOf(elements, size);
    }

}
