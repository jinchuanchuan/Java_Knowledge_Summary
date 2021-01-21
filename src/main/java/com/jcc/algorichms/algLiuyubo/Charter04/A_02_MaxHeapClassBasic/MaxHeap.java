package com.jcc.algorichms.algLiuyubo.Charter04.A_02_MaxHeapClassBasic;

import java.util.*;

public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    /**
     * 构造函数, 构造一个空堆, 可容纳capacity个元素
     * @param capacity 大小
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Object[capacity + 1];
        this.count = 0;
    }

    /**
     * 返回堆中的元素个数
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 测试 MaxHeap
     * @param args
     */
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        System.out.println(heap.size());
    }
}
