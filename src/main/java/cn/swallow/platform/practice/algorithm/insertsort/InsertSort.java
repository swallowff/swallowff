package cn.swallow.platform.practice.algorithm.insertsort;

import java.util.Arrays;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class InsertSort {
    public static void insertionSort(int[] a) {
        if (null == a || a.length < 2) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            // 暂存当前值
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp < a[j]) {
                // 后移
                a[j + 1] = a[j];
                j--;
            }
            // 当前值归位
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args){
        int[] a = {90,65,9,12,2};
        InsertSort.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }


}
