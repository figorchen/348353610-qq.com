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
        for (int i = 0; i < a.length; ++i) { // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) break; // 没有数据交换，提前退出
        }
    }


    @Override
    public String getName() {
        return "冒泡排序";
    }
}
