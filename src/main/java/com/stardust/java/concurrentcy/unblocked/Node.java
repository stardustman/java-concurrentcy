package com.stardust.java.concurrentcy.unblocked;

import java.util.concurrent.atomic.AtomicReference;

public class Node<E> {
    E e;
    AtomicReference<Node<E>> next;

    public Node(E e, Node<E> next) {
        this.e = e;
        this.next = new AtomicReference<Node<E>>(next);
    }
}