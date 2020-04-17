package com.ck.test.sort;

import java.util.Arrays;

public class TimSort implements ISort {
    @Override
    public void sort(int[] a) {
        Arrays.sort(a);
    }

    @Override
    public String getName() {
        return "TimSort";
    }
}
