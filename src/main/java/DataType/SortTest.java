package DataType;

import org.junit.Test;

import java.util.*;

public class SortTest {

    /**
     * 归并排序
     */
    public void MergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }


    /**
     * 合并两部分有序数组
     */
    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];//tmp
        int p1 = left, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }

        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];

        for (int i = 0; i < tmp.length; i++) {
            a[left + i] = tmp[i];
        }
    }


    /**
     * 归并排序2
     */
    public void MergeSort2(int[] arr) {
        int[] tmp = new int[arr.length];
        _MergeSort2(arr, 0, arr.length - 1, tmp);
    }

    public void _MergeSort2(int[] arr, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end) / 2;
            _MergeSort2(arr, start, mid, tmp);
            _MergeSort2(arr, mid + 1, end, tmp);
            merge2(arr, start, mid, end, tmp);
        }
    }

    /**
     * 合并两部分有序数组2
     */
    public void merge2(int[] a, int left, int mid, int right, int[] tmp) {
        int n = right - left + 1;
        int p1 = left, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }

        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];

        for (int i = 0; i < n; i++) {
            a[left + i] = tmp[i];
        }
    }


    /**
     * 快速排序，双指针
     */
    public void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = _QuickSortPartition(arr, left, right);
            QuickSort(arr, left, mid - 1);
            QuickSort(arr, mid + 1, right);
        }
    }

    /**
     * 将数组分割为两部分，前一半均小于分界点，后一般均大于等于分界点。
     * 返回分界点
     */
    public int _QuickSortPartition(int[] arr, int left, int right) {
        int base = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (arr[j] >= base && i < j) j--;
            while (arr[i] <= base && i < j) i++;

            //swap(i,j)
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //swap(left,i)
        arr[left] = arr[i];
        arr[i] = base;

        return i;
    }


    @Test
    public void testSort() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        MergeSort(a, 0, a.length - 1);
        System.out.println("MergeSort：");
        System.out.println(Arrays.toString(a));

        int[] a2 = {49, 38, 65, 97, 76, 13, 27, 50};
        MergeSort2(a2);
        System.out.println("MergeSort2：");
        System.out.println(Arrays.toString(a2));

        int[] a3 = {49, 38, 65, 97, 76, 13, 27, 50};
        QuickSort(a3, 0, a3.length - 1);
        System.out.println("QuickSort：");
        System.out.println(Arrays.toString(a3));

    }


    public static void main(String[] args) {
        System.out.println("SortTest");

    }

}
