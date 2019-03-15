package com.stardust.java.concurrentcy.unblocked;

import java.util.concurrent.atomic.AtomicReference;

public class PlainQueue<E> {

    private Node<E> sentinel = new Node<E>(null, null); //哨兵节点

    @SuppressWarnings("unused")
	private Node<E> head = sentinel;   //头节点引用
    private Node<E> tail = sentinel;   //尾节点引用

    public boolean add(E e) {
        Node<E> node = new Node<E>(e, null); //创建一个新的节点
        tail.next = new AtomicReference<Node<E>>(node);
        tail = node;
        return true;
    }
}