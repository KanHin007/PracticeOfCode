package sort;

import java.util.Arrays;

public class QuickSort {


    /**
     *
     * 8，7，6，5，4，3，2，1
     *
     * 1，7，6，5，4，3，2，8。。。。
     *
     *
     * 快速排序
     * @param arr 数组
     * @param low 低位
     * @param high 高位
     */
    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit) {
                h--;
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit) {
                l++;
            }

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }

        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
    }


    public static void main(String[] args) {

     //   int[] arr = {0,1,2,3,4,5,6,7,8};

        int[] arr = {8,7,6,5,4,3,2,1,0};
        sort(arr,0,8);

        System.out.println(Arrays.toString(arr));



    }
}
