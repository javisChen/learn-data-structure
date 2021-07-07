package com.kt;

/**
 * 顺序列表简单实现
 *
 * @param <T>
 */
public interface Collection<T> {


    T getElement(int index);

    boolean addElement(T element);

    boolean addElement(T element, int index);

    boolean removeElement(T element);

    Object[] getElements();
}
