package com.kt;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void getElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        Integer element = list.getElement(2);
        System.out.println(element);
    }

    @Test
    public void addElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        list.addElement(88, 1);
    }

    @Test
    public void testAddElement() {
    }

    @Test
    public void removeElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.removeElement(2);

        for (Object element : list.getElements()) {
            System.out.println(element);
        }
    }

    @Test
    public void getElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);

        Object[] elements = list.getElements();
        for (Object element : elements) {
            System.out.println(element);
        }

    }
}