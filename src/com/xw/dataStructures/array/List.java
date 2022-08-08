package com.xw.dataStructures.array;

/**
 * @ClassName: List
 * @Author: MaxWell
 * @Description: List 接口
 * @Date: 2022/8/8 13:35
 * @Version: 1.0
 */
public interface List<E> {
    boolean add(E e);

    E remove(int index);

    E get(int index);
}
