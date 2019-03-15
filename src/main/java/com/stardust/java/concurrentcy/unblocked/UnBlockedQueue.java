package com.stardust.java.concurrentcy.unblocked;

import java.util.concurrent.atomic.AtomicReference;

public class UnBlockedQueue<E> {

    private Node<E> sentinel = new Node<E>(null, null);  //哨兵节点

    @SuppressWarnings("unused")
	private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(sentinel);    //头节点引用
    private AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(sentinel);    //尾节点引用

    public boolean add(E e) {
        Node<E> node = new Node<E>(e, null); //即将插入的节点

        while (true) {
            Node<E> tailNode = tail.get();  //当前的尾节点
            Node<E> tailNext = tailNode.next.get(); //尾节点的下一个节点

            if (tailNext == null) {     //处于稳定状态，尝试插入新节点
                if (tailNode.next.compareAndSet(tailNext, node)) {
                    tail.compareAndSet(tailNode, node);
                    return true;
                }

            } else {    //处于中间状态，帮助上一个线程设置tail的值
                tail.compareAndSet(tailNode, tailNext);
            }
        }
    }
}  