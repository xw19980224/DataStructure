package com.xw.dataStructures.array;

import java.util.Arrays;

/**
 * @ClassName: test2
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/8/8 9:21
 * @Version: 1.0
 */
public class ArrayList<E> implements List<E> {
    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 空元素
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * ArrayList 元素数组缓存区
     */
    transient Object[] elementData;
    /**
     * List 集合元素数量
     */
    private int size;

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 添加元素
     *
     * @param e 元素
     * @return
     */
    @Override
    public boolean add(E e) {
        // 确保内部容量
        int minCapacity = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 判断扩容操作
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        // 添加元素
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // 从原始数组的某个位置，拷贝到目标对象的某个位置开始后n个元素
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");

        System.out.println(list);

        list.remove(9);

        System.out.println(list);
    }
}
