package com.ck.test.sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements ISort {
    @Override
    public void sort(int[] a) {
        if (a.length < 20) {
            new QuickSort().sort(a);
            return;
        }
        // 假设每个桶内元素为20, 需要a.length/20个桶
        final int bucketCount = a.length / 20;
        List<List<Integer>> bucketList = new ArrayList<>(bucketCount);

        // 先找到数组中的最大最小值
        int min=a[0], max=a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                continue;
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        if (min == max) {
            return;
        }

        // 根据最大最小值算出每个桶内装数据的范围  第k个桶的数据范围就是 min+bucketStep*(k-1)->bucketStep*k
        int bucketStep = (max - min) / bucketCount + 1;
        // 保存每个桶的最大数据值
        int[] ints = new int[bucketCount];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (i+1)*bucketStep + min;
            bucketList.add(new ArrayList<>(20));
        }

        // 开始分桶
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (a[i] <= ints[j]) {
                    // 把a[i]装进第j个桶里
                    bucketList.get(j).add(a[i]);
                    break;
                }
            }
        }

        // 把桶内元素按照分桶之后的顺序重新放回数组
        int index = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            for (int j = 0; j < bucketList.get(i).size(); j++) {
                a[index] = bucketList.get(i).get(j);
                index++;
            }
        }



        // 对每个桶来一次快排
        QuickSort quickSort = new QuickSort();
        int nextBucketStartIndex = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            quickSort.sort(a, nextBucketStartIndex, nextBucketStartIndex + bucketList.get(i).size() - 1);
            nextBucketStartIndex += bucketList.get(i).size();
        }
    }

    @Override
    public String getName() {
        return "桶排序";
    }
}
