package com.ck.test.sort;

public class MergeSort implements ISort {
    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int start, int end) {
        if (end <= start) {
            return;
        }
        if (end - start == 1) {
            if (a[start] > a[end]) {
                int tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
            }
            return;
        }
        int r = (end + start) / 2;
//        System.out.println("start=" + start + "  end=" + end + " 拆分成 " + start + "--" + r + "          " + (r+1) + "--" + end);
        mergeSort(a, start, r);
        mergeSort(a, r + 1, end);

        merge(a, start, r, r + 1, end);
    }

    private void merge(int[] a, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int[] temp = new int[rightEnd - leftStart + 1];
        int i = leftStart, j = rightStart, k = 0;
        while (i <= leftEnd || j <= rightEnd) {
            if (i > leftEnd) {
                temp[k] = a[j];
                j++;
            } else if (j > rightEnd) {
                temp[k] = a[i];
                i++;
            } else {
                if (a[i] <= a[j]) {
                    temp[k] = a[i];
                    i++;
                } else {
                    temp[k] = a[j];
                    j++;
                }
            }
            k++;
        }
        System.arraycopy(temp, 0, a, leftStart, temp.length);
    }

    @Override
    public String getName() {
        return "归并排序";
    }
}
