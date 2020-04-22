package com.ck.test.heap;

import java.util.Arrays;

/**
 * 类    名: HeapMain </br>
 * 创建时间: 2020/4/21 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
public class HeapMain {

    public static void main(String[] args) {
        int[] ints = generateArray();
        LittleTopHeap bigTopHeap = new LittleTopHeap(ints);
        System.out.println(Arrays.toString(bigTopHeap.getData()));
        check(bigTopHeap.getData(), false, bigTopHeap.getData().length);
        for (int i = 0; i < ints.length - 2; i++) {
            bigTopHeap.deleteTop();
            System.out.println(Arrays.toString(bigTopHeap.getData()));
            check(bigTopHeap.getData(), false, bigTopHeap.getData().length - i - 1);
        }
    }

    private static void check(int[] a, boolean isBigTopHeap, int length) {
        for (int i = 1; i < length / 2; i++) {
            if (isBigTopHeap) {
                if (a[i] < a[i*2] || a[i] < a[i*2 + 1]) {
                    throw new IllegalStateException("大顶堆出错");
                }
            } else {
                if (a[i] > a[i*2] || a[i] > a[i*2 + 1]) {
                    throw new IllegalStateException("小顶堆出错");
                }
            }
        }
    }

    public static int[] generateArray() {
        int[] a = new int[100];
//        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*100);
//            a[i] = i;
        }
//        int[] a = new int[]{8, 8, 6, 6, 4, 0, 4, 1, 4, 3};
        return a;
    }
}
