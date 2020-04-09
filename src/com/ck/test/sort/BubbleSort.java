package com.ck.test.sort;

/**
 * 类    名: BubbleSort </br>
 * 创建时间: 2020/4/9 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class BubbleSort implements ISort {
    @Override
    public void sort(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }
}
