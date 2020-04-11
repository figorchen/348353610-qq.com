package com.ck.test.sort;

/**
 * 类    名: QuickSort </br>
 * 创建时间: 2020/4/10 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class QuickSort implements ISort {
    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    void sort(int[] a, int start, int end) {
        int partition = partition(a, start, end);
        if (partition == -1) {
//            System.out.println("start=" + start + "  end=" + end + "   结束");
            return;
        }
//        System.out.println("start=" + start + "  end=" + end + " 拆分成 " + start + "--" + (partition - 1) + "          " + (partition+1) + "--" + end);
        if (start < partition-1) {
            sort(a, start, partition-1);
        }
        if (partition + 1 < end) {
            sort(a, partition + 1, end);
        }
    }

    private int partition(int[] a, int start, int end) {
        if (start >= end) {
            //只有一个元素时, 已经完全有序
            return -1;
        }

//        StringBuilder sb = new StringBuilder("[");
//        for (int i = start; i < end + 1; i++) {
//            sb.append(a[i]).append(", ");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append("]");
//        System.out.println(start+ "到" +end+"分区前:   " + sb.toString());

        int initP = (start + end) / 2;
        int target = a[initP];
        if (a[initP] != a[end]) {
            a[initP]= a[end];
            a[end] = target;
        }

        int pivot = start;
        for (int i = start; i <= end; i++) {
            if (a[i] < target) {
                if (a[pivot] != a[i]) {
                    int tmp = a[pivot];
                    a[pivot] = a[i];
                    a[i] = tmp;
                }
                pivot++;
            }
        }
        if (a[pivot] != target) {
            int tmp = a[pivot];
            a[pivot] = target;
            a[end] = tmp;
        }

//        StringBuilder sb1 = new StringBuilder("[");
//        for (int i = start; i < end + 1; i++) {
//            sb1.append(a[i]).append(", ");
//        }
//        sb1.deleteCharAt(sb1.length() - 1);
//        sb1.deleteCharAt(sb1.length() - 1);
//        sb1.append("]");
//        System.out.println(start+ "到" +end+"分区后:   " + sb1.toString());

        if (end - start == 1) {
            // 2个元素时, 排完后已经完全有序
            return -1;
        }
        // 大于2个元素时, 排完返回标的
        return pivot;
    }

    @Override
    public String getName() {
        return "快速排序";
    }
}
