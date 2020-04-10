package com.ck.test.sort;

/**
 * 类    名: SelectSort </br>
 * 创建时间: 2020/4/10 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class SelectSort implements ISort {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    @Override
    public String getName() {
        return "选择排序";
    }
}
