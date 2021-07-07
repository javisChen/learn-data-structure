package com.kt;


import org.junit.Before;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    private ArrayList<Integer> sequenceList;

    @Before
    public void setup() {
        sequenceList = new ArrayList<>(10);
    }

    @org.junit.Test
    public void addElement() {
        assertNotNull(sequenceList);
        boolean b = sequenceList.addElement(1);
        assertTrue(b);
        b = sequenceList.addElement(2);
        assertTrue(b);
        b = sequenceList.addElement(3);
        assertTrue(b);
        b = sequenceList.addElement(4);
        assertTrue(b);
        b = sequenceList.addElement(88);
        assertTrue(b);
        b = sequenceList.addElement(22);
        assertTrue(b);
        b = sequenceList.addElement(99, 2);
        assertTrue(b);
    }

    @org.junit.Test
    public void getElement() {
        boolean b = sequenceList.addElement(1);
        Integer element = sequenceList.getElement(0);
        assertNotNull(element);
    }

    @org.junit.Test
    public void testAddElement() {
    }

    @org.junit.Test
    public void removeElement() {
        addElement();
        sequenceList.removeElement(22);
    }

    @org.junit.Test
    public void size() {
    }

    @org.junit.Test
    public void getElements() {
        Object[] elementData = new Object[]{1,2,3,4,5};
        System.arraycopy(elementData, 2, elementData, 0, 3);
        for (Object elementDatum : elementData) {
            System.out.println(elementDatum);
        }
    }
}