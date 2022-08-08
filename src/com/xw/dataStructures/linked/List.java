package com.xw.dataStructures.linked;

/**
 * @ClassName: List
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/7/27 16:48
 * @Version: 1.0
 */
public interface List<E> {
    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();
}
