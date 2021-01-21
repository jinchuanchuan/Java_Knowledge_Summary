package com.jcc.algorichms.algLiuyubo.Charter04.A_03_ShiftUp;

public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    /**
     * 构造函数, 构造一个空堆, 可容纳capacity个元素
     * @param capacity 大小
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;

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


    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {
        while(k > 1 && data[k/2].compareTo(data[k]) < 0) {
            swap(k/2, k);
            k /=2;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int k) {
        Item temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }

    /**
     * 测试 MaxHeap
     * @param args
     */
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        System.out.println(maxHeap.size());
    }
}
