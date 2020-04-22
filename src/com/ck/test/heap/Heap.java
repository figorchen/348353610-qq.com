package com.ck.test.heap;

import com.ck.test.sort.ISort;

/**
 * 类    名: Heap </br>
 * 创建时间: 2020/4/21 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
abstract class Heap implements ISort {

    protected int[] data;
    protected int count;

    public Heap(int[] data) {
        if (data == null) {
            return;
        }
        this.data = new int[data.length + 1];
        for (int aData : data) {
            insert(aData);
        }
    }

    public int[] getData() {
        return data;
    }

    public void insert(int item) {
        count++;
        data[count] = item;
        heapifyB2T(count);
    }

    public void deleteTop() {
        data[1] = data[count];
        data[count] = -1;
        count--;
        heapifyT2B(1);
    }

    // 自上而下堆化
    public abstract void heapifyT2B(int index);

    // 自下而上堆化
    public abstract void heapifyB2T(int index);

    @Override
    public void sort(int[] a) {
        this.data = new int[a.length + 1];
        for (int aData : a) {
            insert(aData);
        }
        while (count > 1) {
            int tmp = data[1];
            data[1] = data[count];
            data[count] = tmp;
            count--;
            heapifyT2B(1);
        }
    }


}
