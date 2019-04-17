package cn.swallow.platform.practice.algorithm.dichotomy;

import java.util.Arrays;

/**
 * 二分法查找
 * @author shenyu
 * @create 2019/4/12
 */
public class DichotomySort {

    public int search(int[] source,int target){
        Arrays.sort(source);

        System.out.println("sortedArray: "+Arrays.toString(source));
        int begin = 0;
        int end = source.length;
        while (begin <= end){
            int mid = (end + begin) /2;
            if (source[mid] == target){
                return mid;
            }
            if (source[mid] > target){
                end = mid - 1;
            }
            if (source[mid] < target){
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        DichotomySort sort = new DichotomySort();
        System.out.println(sort.search(new int[]{1,15,5,2,78,23,9},5));
    }


}
