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
        int[] a = generateArray();
        for (int i = 0; i < sorts.size(); i++) {
            int[] clone = a.clone();
            long timestamp = System.currentTimeMillis();
            sorts.get(i).sort(clone);
            timestamp = System.currentTimeMillis() - timestamp;
            System.out.println(Arrays.toString(clone));
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

    private static int[] generateArray() {
//        int[] a = new int[100];
        int[] a = new int[50000];
        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random()*1000);
            a[i] = i;
        }
//        int[] a = new int[]{91, 0, 4, 25, 44, 88, 73, 64, 26, 67, 65, 25, 69, 54, 42};
        return a;
    }
}
