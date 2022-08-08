package com.xw.dataStructures.linked;

/**
 * @ClassName: LinkedList
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/7/27 14:28
 * @Version: 1.0
 */
public class LinkedList<E> implements List<E> {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    // 链表节点
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> next, E item, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    // 头插节点
    void linkFirst(E e) {
        final Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else {
            f.prev = newNode;
        }
        size++;
    }

    // 尾插节点
    void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    // 拆链操作
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    // 删除节点
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        return false;
    }

    @Override
    public boolean addLast(E e) {
        return false;
    }


    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void printLinkList() {

    }
}
