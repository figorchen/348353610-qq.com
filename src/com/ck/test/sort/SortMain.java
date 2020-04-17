package com.ck.test.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类    名: SortMain </br>
 * 创建时间: 2020/4/9 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
public class SortMain {
    public static void main(String[] args) {
        List<ISort> sorts = new ArrayList<>();
        sorts.add(new BubbleSort());
        sorts.add(new InsertSort());
        sorts.add(new SelectSort());
        sorts.add(new MergeSort());
        sorts.add(new QuickSort());
        sorts.add(new BucketSort());
        sorts.add(new CountSort());
        sorts.add(new TimSort());
        int[] a = generateArray();
        for (int i = 0; i < sorts.size(); i++) {
            int[] clone = a.clone();
            long timestamp = System.currentTimeMillis();
            sorts.get(i).sort(clone);
            timestamp = System.currentTimeMillis() - timestamp;
//            System.out.println(Arrays.toString(clone));
            check(clone);
            System.out.println(sorts.get(i).getName() + "成功!   耗时: " + timestamp + "ms");
        }

    }

    private static void check(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                throw new IllegalStateException("错了!!!");
            }
        }
    }

    public static int[] generateArray() {
//        int[] a = new int[100];
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*100);
//            a[i] = i%100;
        }
//        int[] a = new int[]{18, 35, 73, 106, 112, 136, 195, 213, 245, 267, 279, 301, 346, 356, 383, 388, 399, 433, 450, 475, 501, 501, 507, 514, 527, 539, 568, 605, 647, 658, 666, 742, 750, 790, 800, 811, 827, 944, 991, 996};
        return a;
    }
}
