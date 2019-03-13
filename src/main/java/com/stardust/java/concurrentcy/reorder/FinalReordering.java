package com.stardust.java.concurrentcy.reorder;

/**
 * final变量依靠它的禁止重排序规则，保证在使用过程中的安全性。一旦被赋值成功，
 * 它的值在之后程序执行过程中都不会改变，也不存在所谓的内存可见性问题。
 * @author young
 *
 */
public class FinalReordering {

    int i;
    final int j;

    static FinalReordering obj;

    public FinalReordering() {
        i = 1;
        j = 2;
    }

    public static void write() {
    	System.out.println(Thread.currentThread().getName());
        obj = new FinalReordering();
    }

    public static void read() {
        FinalReordering finalReordering = FinalReordering.obj;
        int i = finalReordering.i;
        int j = finalReordering.j;
        System.out.println(Thread.currentThread().getName() + " i = " + i + ", j = " + j );
    }
}