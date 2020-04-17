package com.ck.test.search;

import com.ck.test.sort.TimSort;

import java.util.Arrays;
import java.util.HashSet;

public class SearchMain {
    public static void main(String[] args) {
        int[] a = generateArray();
//        int value = (int) (Math.random()*100);
//        int value =a[0];
        int value = 58;
        new TimSort().sort(a);

        HashSet<Integer> equals = new HashSet<>();
        int firstEqual = -1, lastEqual = -1, fristGe = -1, lastLE = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                equals.add(i);
                lastEqual = i;
                lastLE = i;
                if (firstEqual == -1) {
                    firstEqual = i;
                    fristGe = i;
                }
            }
        }

        System.out.println(value);
        System.out.println(Arrays.toString(a));
        int index = new BinarySearch().search(a, value, SearchModeEnum.EQUAL);
        if (index == -1) {
            if (equals.size() != 0) {
                throw new IllegalStateException(SearchModeEnum.EQUAL.getModeName() + value + "的元素在: " + Arrays.toString(equals.toArray()));
            }
            System.out.println("没找到" + value);
        } else {
            if (!equals.contains(index)) {
                throw new IllegalStateException(SearchModeEnum.EQUAL.getModeName() + value + "的元素在: " + Arrays.toString(equals.toArray()));
            }
            System.out.println(SearchModeEnum.EQUAL.getModeName() + value + "的元素在: " + index);
        }

        index = new BinarySearch().search(a, value, SearchModeEnum.FIRST_EQUAL);
        if (index == -1) {
            if (firstEqual != -1) {
                throw new IllegalStateException(SearchModeEnum.FIRST_EQUAL.getModeName() + value + "的元素在: " + firstEqual + "   结果是:"+index);
            }
            System.out.println("没找到" + value);
        } else {
            if (firstEqual != index) {
                throw new IllegalStateException(SearchModeEnum.FIRST_EQUAL.getModeName() + value + "的元素在: " + firstEqual + "   结果是:"+index);
            }
            System.out.println(SearchModeEnum.FIRST_EQUAL.getModeName() + value + "的元素在: " + index);
        }

        index = new BinarySearch().search(a, value, SearchModeEnum.LAST_QUEAL);
        if (index == -1) {
            if (lastEqual != -1) {
                throw new IllegalStateException(SearchModeEnum.LAST_QUEAL.getModeName() + value + "的元素在: " + lastEqual + "   结果是:"+index);
            }
            System.out.println("没找到" + value);
        } else {
            if (lastEqual != index) {
                throw new IllegalStateException(SearchModeEnum.LAST_QUEAL.getModeName() + value + "的元素在: " + lastEqual + "   结果是:"+index);
            }
            System.out.println(SearchModeEnum.LAST_QUEAL.getModeName() + value + "的元素在: " + index);
        }

        index = new BinarySearch().search(a, value, SearchModeEnum.FIRST_GE);
        if (index == -1) {
            if (fristGe != -1) {
                throw new IllegalStateException(SearchModeEnum.FIRST_GE.getModeName() + value + "的元素在: " + fristGe + "   结果是:"+index);
            }
            System.out.println("没找到" + value);
        } else {
            if (fristGe != index) {
                throw new IllegalStateException(SearchModeEnum.FIRST_GE.getModeName() + value + "的元素在: " + fristGe + "   结果是:"+index);
            }
            System.out.println(SearchModeEnum.FIRST_GE.getModeName() + value + "的元素在: " + index);
        }
    }

    public static int[] generateArray() {
//        int[] a = new int[100];
//        int[] a = new int[100];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random()*100);
////            a[i] = i%30;
//        }
        int[] a = new int[]{1, 4, 6, 7, 9, 10, 10, 10, 10, 11, 13, 13, 14, 14, 15, 17, 17, 17, 17, 19, 19, 22, 22, 23, 23, 23, 24, 26, 26, 26, 26, 28, 28, 29, 31, 32, 33, 34, 34, 34, 39, 39, 42, 42, 42, 44, 44, 44, 44, 46, 46, 46, 48, 48, 48, 49, 50, 51, 53, 55, 55, 57, 57, 60, 61, 61, 62, 63, 65, 65, 67, 71, 71, 71, 73, 73, 74, 74, 74, 75, 76, 76, 76, 77, 77, 78, 81, 81, 84, 84, 86, 87, 87, 88, 91, 91, 92, 94, 95, 97};
        return a;
    }
}
