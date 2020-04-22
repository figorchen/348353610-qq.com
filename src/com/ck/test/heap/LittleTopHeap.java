package com.ck.test.heap;

/**
 * 类    名: LittleTopHeap </br>
 * 创建时间: 2020/4/22 </br>
 * 类 描 述: 小顶堆</br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class LittleTopHeap extends Heap {
    public LittleTopHeap(int[] data) {
        super(data);
    }

    @Override
    public void heapifyT2B(int index) {
        if (index > count/2) {
            return;
        }
        int swapIndex = index;
        if (data[2*index] < data[swapIndex]) {
            swapIndex = 2*index;
        }
        if (2*index + 1 <= count && data[2*index + 1] < data[swapIndex]) {
            swapIndex = 2*index + 1;
        }

        if (index == swapIndex) {
            return;
        }

        int tmp = data[index];
        data[index] = data[swapIndex];
        data[swapIndex] = tmp;
        heapifyT2B(swapIndex);
    }

    @Override
    public void heapifyB2T(int index) {
        if (index == 1) {
            return;
        }
        int parentIndex = index / 2;

        if (data[parentIndex] > data[index]) {
            // 父节点比自己小, 直接跟父节点换位置
            int tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            heapifyB2T(parentIndex);
        }
    }

    @Override
    public String getName() {
        return "小顶堆排序";
    }
}
