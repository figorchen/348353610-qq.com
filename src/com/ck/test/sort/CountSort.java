package com.ck.test.sort;

public class CountSort implements ISort {
    @Override
    public void sort(int[] a) {
        if (a.length < 20) {
            new QuickSort().sort(a);
            return;
        }
        // 数据范围是0-99, 需要100个桶
        final int bucketCount = 100;
        int[] buckets = new int[bucketCount];

        // 开始分桶
        for (int i = 0; i < a.length; i++) {
            buckets[a[i]] = buckets[a[i]]+1;
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i-1];
        }

        int b[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int score = a[i];
            b[buckets[score] - 1] = score;
            buckets[score]--;
        }
        System.arraycopy(b, 0, a, 0, a.length);
    }

    @Override
    public String getName() {
        return "计数排序";
    }
}
