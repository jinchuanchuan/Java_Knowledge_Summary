package com.jcc.algorichms.sort;

public class MaxHeap {
    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity+1];
        count=0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int num) {
        assert count+1 <= capacity;
        data[count+1] = num;
        count++;
        shiftUp(count);
    }

    public int extractMax() {
        int res = data[1];
        swap( 1 , count );
        count--;
        shiftDown(1);

        return res;
    }

    private void shiftDown(int k) {
        while(2*k <= count) {
            int j = 2*k;
            if(j+1 <= count && data[j+1] > data[j]) j++;
            if( data[k] >= data[j]) break;
            swap(k, j);
            k = j;
        }
    }

    // parent(i) = i/2
    private void shiftUp(int k) {
        while(k > 1 && data[k/2] < data[k]) {
            swap(k/2, k);
            k /= 2;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
