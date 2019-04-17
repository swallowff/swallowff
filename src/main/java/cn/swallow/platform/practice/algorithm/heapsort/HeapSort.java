package cn.swallow.platform.practice.algorithm.heapsort;

import java.util.Arrays;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class HeapSort {
    public int getLeftLeafIndex(int index) {
        //获取左叶子结点
        return (2 * index) + 1;
    }

    public void swapValue(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void sort(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0; j--) {
            swapValue(array, 0, j);
            adjustHeap(array, 0, j);
        }
    }

    public void adjustHeap(int[] array, int offset, int length) {
        int temp = array[offset];

        for (int k = getLeftLeafIndex(offset); k < length; k = (2 * k) + 1) {
            //当父节点发生变化时, 会影响子节点的堆性质, 需要重建所有受影响的子节点
            if (((k + 1) < length) && (array[k] < array[k + 1])) {
                //k指向孩子结点中大的那个
                //避免已排序的序列被打乱
                k += 1;
            }

            if (temp < array[k]) {
                //如果孩子结点大于父节点, 将值赋值给父节点, 同时当前结点设置为孩子结点, 继续检查并调整可能受影响的孩子结点
                array[offset] = array[k];
                offset = k;
            } else {
                break;
            }
        }
        //将初始堆顶的值插入最终的位置, (相当于只交换最终确定位置的值)
        array[offset] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = new int[] {
                9, 8, 7, 6, 5, 4, 3, 2, 1, 87, 23, 32, 232, 123, 98, 33, 42,
                2837, 3874
        };
        heapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

