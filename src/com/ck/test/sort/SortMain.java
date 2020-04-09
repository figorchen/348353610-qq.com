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
        for (int i = 0; i < sorts.size(); i++) {
            int[] a = generateArray();
            long timestamp = System.currentTimeMillis();
            sorts.get(i).sort(a);
            timestamp = System.currentTimeMillis() - timestamp;
            System.out.println(Arrays.toString(a));
            check(a);
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
        int[] a = new int[50000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*50000);
        }
        return a;
    }
}
