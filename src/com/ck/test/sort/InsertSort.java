package com.ck.test.sort;

/**
 * 类    名: InsertSort </br>
 * 创建时间: 2020/4/9 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class InsertSort implements ISort {

    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    @Override
    public String getName() {
        return "插入排序";
    }
}
